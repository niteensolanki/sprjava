package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_code")
	private String empCode;

	@Column(name = "emp_mobile_no")
	private String empMobNo;

	@Column(name = "emp_email")
	private String emailId;

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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empCode=" + empCode + ", empMobNo=" + empMobNo
				+ ", emailId=" + emailId + "]";
	}

}
