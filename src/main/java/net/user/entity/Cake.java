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
@Table(name = "cake")
public class Cake {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cakeid;
    @Column(nullable = false)
    private String cakename;
    
    @Column(name = "userid")
    private Integer userid;
    
    @Column(nullable = false)
    private Integer price;
    
    @Column(nullable = false)
    private String cakeimage;
    
	public void setCakename(String cakename) {
		this.cakename = cakename;
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

	public String getCakeimage() {
		return cakeimage;
	}

	public void setCakeimage(String cakeimage) {
		this.cakeimage = cakeimage;
	}
    
	
}
