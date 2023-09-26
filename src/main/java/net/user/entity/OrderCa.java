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
@Table(name = "orderca")
public class OrderCa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;

    @Column(name = "cakeid")
    private Integer cakeid;
    
    @Column(name = "datecreate")
    private String datecreate;

    @Column(name = "dateship")
    private String dateship;
    
    @Column(name = "number")
	private Integer number;
	
    @Column(name = "customer")
	private String customer;
	
    @Column(name = "phone")
	private String phone;
	
    @Column(name = "price")
    private Integer price;
    
    @Column(name = "address")
	private String address;

    @Column(name = "status")
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
}
