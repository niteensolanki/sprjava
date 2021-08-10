package com.demo.Vo;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeVo {

	private Long id;
	private String empName;

	private String empCode;

	private String empMobNo;

	private String emailId;

	private String adr_houseno;
	private String adr_flrno;
	private String adr_street;
	private String adr_area;

	private int adr_pinno;
	private int city_id;

	private int dist_id;

	private int state_id;

	private int country_id;

	private MultipartFile[] addressProfs;
	private List<String> documentList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpMobNo() {
		return empMobNo;
	}

	public void setEmpMobNo(String empMobNo) {
		this.empMobNo = empMobNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public int getAdr_pinno() {
		return adr_pinno;
	}

	public void setAdr_pinno(int adr_pinno) {
		this.adr_pinno = adr_pinno;
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

	public MultipartFile[] getAddressProfs() {
		return addressProfs;
	}

	public void setAddressProfs(MultipartFile[] addressProfs) {
		this.addressProfs = addressProfs;
	}

	public List<String> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<String> documentList) {
		this.documentList = documentList;
	}

	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", empName=" + empName + ", empCode=" + empCode + ", empMobNo=" + empMobNo
				+ ", emailId=" + emailId + ", adr_houseno=" + adr_houseno + ", adr_flrno=" + adr_flrno + ", adr_street="
				+ adr_street + ", adr_area=" + adr_area + ", adr_pinno=" + adr_pinno + ", city_id=" + city_id
				+ ", dist_id=" + dist_id + ", state_id=" + state_id + ", country_id=" + country_id + ", addressProfs="
				+ Arrays.toString(addressProfs) + ", documentList=" + documentList + "]";
	}

}
