package net.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "orderCake")
public class OrderCake {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderid;
	
    @Column(name = "cakeid")
	private Integer cakeid;
    
    @Column(name = "number")
	private Integer number;
    
    @Column(name = "cakeName")	
	private String cakeName;
	
    @Column(name = "customer")
	private String customer;
	
    @Column(name = "phone")
	private String phone;
	
    @Column(name = "address")
	private String address;
	
    @Column(name = "dateShip")
	private String dateShip;
	
    @Column(name = "dateOrder")
	private String dateOrder;

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

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateShip() {
		return dateShip;
	}

	public void setDateShip(String dateShip) {
		this.dateShip = dateShip;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
    
}
