package com.store.recognize;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import com.store.recognize.FFT.Complex;
import boofcv.alg.filter.binary.BinaryImageOps;
import boofcv.alg.filter.binary.Contour;
import boofcv.alg.filter.binary.ThresholdImageOps;
import boofcv.alg.misc.ImageStatistics;
import boofcv.alg.shapes.FitData;
import boofcv.alg.shapes.ShapeFittingOps;
import boofcv.gui.feature.VisualizeShapes;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.ConnectRule;
import boofcv.struct.image.GrayF32;
import boofcv.struct.image.GrayU8;
import georegression.struct.curve.EllipseRotated_F64;
import georegression.struct.point.Point2D_I32;
import net.user.entity.Leaf;

public class Utils {

	private Leaf leaf;
	
	
	public Leaf getLeaf() {
		return leaf;
	}

	public void setLeaf(Leaf leaf) {
		this.leaf = leaf;
	}


public String analysisImage(byte[] image) {

		  String str ="GOOD";
		  
		  System.out.println("image url=");
		 
		  try {
			  
			  	InputStream in = new ByteArrayInputStream(image);
				
//				 BufferedImage bufferedImage =
//				 UtilImageIO.loadImage(UtilIO.pathExample("F:/temp/test/1.jpg"));
//				 image2 = ConvertBufferedImage.convertTo(input, image2);
			  	
			  	BufferedImage bufferedImage = ImageIO.read(in);
//			  	File outputfile = new File("F:/temp/test/image.jpg");
//			  	ImageIO.write(bufferedImage, "jpg", outputfile);
			  	
			    BufferedImage resized = new BufferedImage(bufferedImage.getWidth() + 4, bufferedImage.getHeight() + 4, bufferedImage.getType());
			    Graphics g = resized.getGraphics();
			    g.setColor(Color.BLACK);
			    g.fillRect(0,0,resized.getWidth(),resized.getHeight());
			    g.drawImage(bufferedImage, 2,2, bufferedImage.getWidth(), bufferedImage.getHeight(), null);

			    /* Convert to BufferedImage to Gray-scale image and prepare Binary image. */
			    GrayF32 input = ConvertBufferedImage.convertFromSingle(resized, null, GrayF32.class);
			  	
//				GrayF32 input = ConvertBufferedImage.convertFromSingle(bufferedImage, null, GrayF32.class);
				
				GrayU8 binary = new GrayU8(input.width, input.height);
				
				double mean = ImageStatistics.mean(input);

				// System.out.println(mean);

				// create a binary image by thresholding-+`+`
				ThresholdImageOps.threshold(input, binary, (float) mean, true);

				// reduce noise with some filtering
				GrayU8 filtered = BinaryImageOps.erode8(binary, 1, null);

				filtered = BinaryImageOps.dilate8(filtered, 1, null);

				// BufferedImage image2 =
				// UtilImageIO.loadImage(UtilIO.pathExample("D:\\Leaf\\Cachua_2.JPG"));
				// image2 = ConvertBufferedImage.convertTo(input, image2);
				//
				// Find the contour around the shapes
				List<Contour> contours = BinaryImageOps.contour(filtered, ConnectRule.EIGHT, null);

				// Fit an ellipse to each external contour and draw the results
				Graphics2D g2 = bufferedImage.createGraphics();
				
				g2.setStroke(new BasicStroke(3));
				
				g2.setColor(Color.BLUE);

				this.leaf = new Leaf();
				
				for (Contour c : contours) {

					FitData<EllipseRotated_F64> ellipse = ShapeFittingOps.fitEllipse_I32(c.external, 0, false, null);
					double eclipse = 0;
					if(ellipse.shape.b !=0)
						eclipse = ellipse.shape.a / ellipse.shape.b;
					
					this.leaf.setEclipse(eclipse);
					
					Graphics2D g3 = bufferedImage.createGraphics();
					g3.setStroke(new BasicStroke(2));
					g3.setColor(Color.RED);
					
					List<Point2D_I32> lstFourier = new ArrayList<Point2D_I32>();
					List<Point2D_I32> lstPoint = c.external;
					for (int i = 0; i < lstPoint.size(); i++) {
						int mod = (int) lstPoint.size() / 128;
						int b = lstPoint.size() - mod * 128;
						if (mod > 0)
							if (i % mod == 0 && i <= (128 - b) * mod) {
								lstFourier.add(lstPoint.get(i));
								g3.drawLine(lstPoint.get(i).x, lstPoint.get(i).y, lstPoint.get(i).x + 1, lstPoint.get(i).y + 1);
							} else if (i > (128 - b) * mod)
								if ((i - (128 - b) * mod) % (mod + 1) == 0) {
									lstFourier.add(lstPoint.get(i));
									g3.drawLine(lstPoint.get(i).x, lstPoint.get(i).y, lstPoint.get(i).x + 1,
											lstPoint.get(i).y + 1);
								}
					}
					
					double distance = caculateSimilarityMeasurement(lstFourier);
					
					str = str + distance;
					for (int i = 0; i < lstPoint.size(); i++) {
						g3.drawLine(lstPoint.get(i).x, lstPoint.get(i).y, lstPoint.get(i).x + 1, lstPoint.get(i).y + 1);
					}
					 VisualizeShapes.drawEllipse(ellipse.shape, g3);
					}

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write( bufferedImage, "jpg", baos );
				baos.flush();
//				this.leaf.setImage(baos.toByteArray());
				baos.close();
				
//				ShowImages.showDialog(bufferedImage);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  return str;
	}

private  double caculateSimilarityMeasurement( List<Point2D_I32> lstFourier) {
	// TODO Auto-generated method stub
	System.out.println(" lstFourier.size()=" + lstFourier.size());

	List<Double> lstFFT = getFFTofImage(lstFourier);
	
	this.leaf.setDFT(lstFFT.toString());
	
	double distance=1;
	
	this.leaf.setDSM(distance);
	
	return distance;
}


public  double caculateSimilarityMeasurementFromString(String leafDFT, String treeDFT){
	
	
	String[] lstleafDFT = leafDFT.substring(1, leafDFT.length()-1).split(",");
	String[] lsttreeDFT = treeDFT.substring(1, treeDFT.length()-1).split(",");

	double distance=0;

	for(int i =0; i< lstleafDFT.length;i++){
		
		double leafdft = Double.parseDouble(lstleafDFT[i]);
		double treedft = Double.parseDouble(lsttreeDFT[i]);
		distance = distance + Math.pow(Math.abs(leafdft) - Math.abs(treedft),2);
	}
	
	distance = Math.sqrt(distance);

	System.out.println("distance="+distance);
	
	return distance;
	
};



private void caculateSimilarityMeasurement(List<Point2D_I32> lstFourier, List<Point2D_I32> similarityImage) {
	// TODO Auto-generated method stub
	System.out.println(" lstFourier.size()=" + lstFourier.size());
	System.out.println(" similarityImage.size()=" + similarityImage.size());

	List<Double> lstFFT = getFFTofImage(lstFourier);
	List<Double> lstFFTSimilarity = getFFTofImage(similarityImage);
	
	double distance=0;

	for(int i =0; i< lstFFT.size();i++){
		
		distance = distance + Math.pow(Math.abs(lstFFT.get(i)) - Math.abs(lstFFTSimilarity.get(i)),2);
	}
	
	distance = Math.sqrt(distance);

	System.out.println("distance="+distance);
}

private List<Double> getFFTofImage(List<Point2D_I32> lstFourier) {
	Point2D_I32 center = new Point2D_I32();
	List<Double> meshDistance = new ArrayList<Double>();

	for (int i = 0; i < lstFourier.size(); i++) {
		center.x = center.x + lstFourier.get(i).x;
		center.y = center.y + lstFourier.get(i).y;
	}

	center.x = center.x / lstFourier.size();
	center.y = center.y / lstFourier.size();
	System.out.println("center x,y= " + center.x + "," + center.y);

	for (int u = 0; u < lstFourier.size(); u++) {
		double m = 0;
		for (int i = 0; i < lstFourier.size(); i++) {
			double d1 = Math.pow(lstFourier.get(i).x - center.x,2) + Math.pow(lstFourier.get(i).y - center.y,2);
			
			double d2 = Math.pow(lstFourier.get(u).x - center.x,2) + Math.pow(lstFourier.get(u).y - center.y,2);
			m = m + Math.sqrt(d1) + Math.sqrt(d2);
		}

		// System.out.println("m=" + m);
		
		meshDistance.add(m);
	}

	int N = meshDistance.size();// Integer.parseInt(args[0]);
	Complex[] x = new Complex[N];

	// original data

	//System.out.println("N=" + N);
	for (int i = 0; i < N; i++) {
		x[i] = new Complex(meshDistance.get(i), 0);
	}

	//Complex.show(x, "x");

	// FFT of original data
	Complex[] fft = Complex.fft(x);

	//Complex.show(fft, "fft = fft(x)");

	System.out.println("-------------------------");
	
	List<Double> fftImage = new ArrayList<Double>();
	
	for(int i=0; i< fft.length;i++)
		fftImage.add(fft[i].re()/fft[0].re());
	
	return fftImage;
}	
}
