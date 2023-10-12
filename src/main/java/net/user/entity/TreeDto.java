package net.user.entity;

public class TreeDto {

	private int treeid;
	private String treename;
	private String leafimage;
	private String leavesimage;
	private String flowerimage;
	private String fruitimage;
	private String seedimage;
	private String barkimage;
	private double eclipse;
	private String DFT;
	private String description;
	
	
	public TreeDto(int treeid, String treename, String leafimage, String leavesimage, String flowerimage,
			String fruitimage, String seedimage, String barkimage, double eclipse, String dFT, String description) {
		super();
		this.treeid = treeid;
		this.treename = treename;
		this.leafimage = leafimage;
		this.leavesimage = leavesimage;
		this.flowerimage = flowerimage;
		this.fruitimage = fruitimage;
		this.seedimage = seedimage;
		this.barkimage = barkimage;
		this.eclipse = eclipse;
		DFT = dFT;
		this.description = description;
	}
	public int getTreeid() {
		return treeid;
	}
	public void setTreeid(int treeid) {
		this.treeid = treeid;
	}
	public String getTreename() {
		return treename;
	}
	public void setTreename(String treename) {
		this.treename = treename;
	}
	public String getLeafimage() {
		return leafimage;
	}
	public void setLeafimage(String leafimage) {
		this.leafimage = leafimage;
	}
	public String getLeavesimage() {
		return leavesimage;
	}
	public void setLeavesimage(String leavesimage) {
		this.leavesimage = leavesimage;
	}
	public String getFlowerimage() {
		return flowerimage;
	}
	public void setFlowerimage(String flowerimage) {
		this.flowerimage = flowerimage;
	}
	public String getFruitimage() {
		return fruitimage;
	}
	public void setFruitimage(String fruitimage) {
		this.fruitimage = fruitimage;
	}
	public String getSeedimage() {
		return seedimage;
	}
	public void setSeedimage(String seedimage) {
		this.seedimage = seedimage;
	}
	public String getBarkimage() {
		return barkimage;
	}
	public void setBarkimage(String barkimage) {
		this.barkimage = barkimage;
	}
	public double getEclipse() {
		return eclipse;
	}
	public void setEclipse(double eclipse) {
		this.eclipse = eclipse;
	}
	public String getDFT() {
		return DFT;
	}
	public void setDFT(String dFT) {
		DFT = dFT;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
