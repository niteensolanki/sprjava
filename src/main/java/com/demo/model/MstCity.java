package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_city")
public class MstCity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "country_id")
	private Long countryId;

	@Column(name = "state_id")
	private Long stateId;

	@Column(name = "dist_id")
	private Long distId;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "city_code")
	private String cityCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getDistId() {
		return distId;
	}

	public void setDistId(Long distId) {
		this.distId = distId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "MstCity [id=" + id + ", countryId=" + countryId + ", stateId=" + stateId + ", distId=" + distId
				+ ", cityName=" + cityName + ", cityCode=" + cityCode + "]";
	}

}
