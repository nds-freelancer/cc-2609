package net.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class OrderCaView {

    private Integer orderid;
    private Integer cakeid;
    private String datecreate;
    private String dateship;
	private Integer number;
	private String customer;
	private String phone;
    private Integer price;
	private String address;
	private String status;
	private String cakename;
	private String statusor;
    
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


	public String getDateship() {
		return dateship;
	}

	public void setDateship(String dateship) {
		this.dateship = dateship;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCakename() {
		return cakename;
	}

	public void setCakename(String cakename) {
		this.cakename = cakename;
	}

	public String getStatusor() {
		return statusor;
	}

	public void setStatusor(String statusor) {
		this.statusor = statusor;
	}
	
}
