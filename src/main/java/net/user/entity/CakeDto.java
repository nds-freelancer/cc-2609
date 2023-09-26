package net.user.entity;

public class CakeDto {

	private Integer cakeid;
	private String cakename;
    private Integer userid;
    private Integer price;
    
    
	public CakeDto() {
		super();
	}

	public Integer getCakeid() {
		return cakeid;
	}

	public void setCakeid(Integer cakeid) {
		this.cakeid = cakeid;
	}


	public String getCakename() {
		return cakename;
	}
	public void setCakename(String cakename) {
		this.cakename = cakename;
	}
	

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
