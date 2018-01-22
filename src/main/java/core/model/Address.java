package core.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnoreProperties
	@Column(name = "addid")
	long addId;
	@Column(name = "empid")
	long empId;
	@Column(name = "houseno")
	int houseNo;
	@Column(name = "streetname")
	String streetName;
	
	String city;
	
	String state;
	
	int zipCode;
	
	String country;

	
	public Address() {}
	
	public Address(long addId, int empId) {
		this.addId = addId;
		this.empId = empId;
	}

	public long getAddId() {
		return addId;
	}

	public void setAddId(long addId) {
		this.addId = addId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipcode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

	

}
