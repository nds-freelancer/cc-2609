package net.user.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.store.recognize.Utils;
import lombok.AllArgsConstructor;
import net.user.entity.Leaf;
import net.user.repository.LeafRepository;
import net.user.service.LeafService;

@Service
@AllArgsConstructor
public class LeafServiceImpl implements LeafService {

    private LeafRepository leafRepository;
//	private Leaf leaf = new Leaf();

    @Override
    public List<Leaf> getAllLeafs() {
        return leafRepository.findAll();
    }
    
    
    @Override
	public Leaf checkLeaf(byte[] b) throws Exception {
		Utils utils = new Utils();
		Leaf leaf = new Leaf();
		  utils.setLeaf(leaf);
		  
//		  	BufferedImage bufferedImage = ImageIO.read(new File("F:/temp/test/2.jpg"));
//			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
//			ImageIO.write(bufferedImage, "jpg", baos1);
//			
//			  byte[] bytes = baos1.toByteArray();	
		  
		  String str = utils.analysisImage(b);
		  
		  leaf = utils.getLeaf();
		  
		  leaf.setDescription("");
		  leaf.setEclipse(leaf.getEclipse());
		  leaf.setDFT(leaf.getDFT());
		  leaf.setDSM(leaf.getDSM());
		  leaf.setTreeid(1);

//			@SuppressWarnings("unchecked")
			List<Leaf> list = leafRepository.findAll();
			
			double mindsm =1;
			int treeid = 1;
			for (int i = 0; i < list.size(); i++) {
				double distance = utils.caculateSimilarityMeasurementFromString(leaf.getDFT(), list.get(i).getDFT());

				if (distance < mindsm) {
					mindsm = distance;
					treeid = list.get(i).getTreeid();
				}
			}
			
			for(int i =0; i< list.size();i++) {
				if(list.get(i).getTreeid() == treeid) {
//					leaf.setLeafname(list.get(i).getTreename());
					leaf.setTreeid(treeid);
					leaf.setDSM(mindsm);
					leaf.setImage(list.get(i).getImage());
					leaf.setLeafname(list.get(i).getLeafname());
				}
			}


		return leaf;
	};

}
