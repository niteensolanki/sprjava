package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_adr")
public class MSTAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "adr_houseno")
	private String adr_houseno;

	@Column(name = "adr_flrno")
	private String adr_flrno;

	@Column(name = "adr_street")
	private String adr_street;

	@Column(name = "adr_area")
	private String adr_area;

	@Column(name = "city_id")
	private int city_id;

	@Column(name = "dist_id")
	private int dist_id;

	@Column(name = "adr_pinno")
	private int adr_pinno;

	@Column(name = "state_id")
	private int state_id;

	@Column(name = "country_id")
	private int country_id;

	@Column(name = "address_proofs")
	private String addressProofs; // add file with comma sep

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getAdr_houseno() {
		return adr_houseno;
	}

	public void setAdr_houseno(String adr_houseno) {
		this.adr_houseno = adr_houseno;
	}

	public String getAdr_flrno() {
		return adr_flrno;
	}

	public void setAdr_flrno(String adr_flrno) {
		this.adr_flrno = adr_flrno;
	}

	public String getAdr_street() {
		return adr_street;
	}

	public void setAdr_street(String adr_street) {
		this.adr_street = adr_street;
	}

	public String getAdr_area() {
		return adr_area;
	}

	public void setAdr_area(String adr_area) {
		this.adr_area = adr_area;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public int getDist_id() {
		return dist_id;
	}

	public void setDist_id(int dist_id) {
		this.dist_id = dist_id;
	}

	public int getAdr_pinno() {
		return adr_pinno;
	}

	public void setAdr_pinno(int adr_pinno) {
		this.adr_pinno = adr_pinno;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	@Override
	public String toString() {
		return "MSTAddress [id=" + id + ", empId=" + empId + ", adr_houseno=" + adr_houseno + ", adr_flrno=" + adr_flrno
				+ ", adr_street=" + adr_street + ", adr_area=" + adr_area + ", city_id=" + city_id + ", dist_id="
				+ dist_id + ", adr_pinno=" + adr_pinno + ", state_id=" + state_id + ", country_id=" + country_id
				+ ", addressProofs=" + addressProofs + "]";
	}

	public String getAddressProofs() {
		return addressProofs;
	}

	public void setAddressProofs(String addressProofs) {
		this.addressProofs = addressProofs;
	}

}
