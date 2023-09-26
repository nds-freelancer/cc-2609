package net.user.entity;

public class OrderDto {

	private Integer orderid;
	private Integer cakeid;
	private Integer number;
	private String cakename;
	private String customer;
	private String phone;
	private String address;
	private String dateship;
	private String dateorder;
	
	private String status;
	

	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getCakeid() {
		return cakeid;
	}
	public void setCakeid(Integer cakeid) {
		this.cakeid = cakeid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCakename() {
		return cakename;
	}
	public void setCakename(String cakename) {
		this.cakename = cakename;
	}
	public String getDateship() {
		return dateship;
	}
	public void setDateship(String dateship) {
		this.dateship = dateship;
	}
	public String getDateorder() {
		return dateorder;
	}
	public void setDateorder(String dateorder) {
		this.dateorder = dateorder;
	}
	
}
