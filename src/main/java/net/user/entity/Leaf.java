package net.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "leaf")
public class Leaf {

	private int leafid;
	private String leafname;
	private String image;
	private double eclipse;
	private String DFT;
	private int treeid;
	private String location;
	private String description;
	private double DSM;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getLeafid() {
		return leafid;
	}

	public void setLeafid(int leafid) {
		this.leafid = leafid;
	}
	
    @Column(name = "leafname")
	public String getLeafname() {
		return leafname;
	}

	public void setLeafname(String leafname) {
		this.leafname = leafname;
	}
	
    @Column(name = "eclipse")
	public double getEclipse() {
		return eclipse;
	}

	public void setEclipse(double eclipse) {
		this.eclipse = eclipse;
	}
	
    @Column(name = "treeid")
	public int getTreeid() {
		return treeid;
	}

	public void setTreeid(int treeid) {
		this.treeid = treeid;
	}
	
	
    @Column(name = "DFT")
	public String getDFT() {
		return DFT;
	}

	public void setDFT(String dFT) {
		DFT = dFT;
	}
	
	
    @Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
    @Column(name = "location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
    @Column(name = "DSM")
	public double getDSM() {
		return DSM;
	}

	public void setDSM(double dSM) {
		DSM = dSM;
	}
	
    @Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
