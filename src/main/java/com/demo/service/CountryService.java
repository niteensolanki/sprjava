package com.demo.service;

import java.util.List;

import com.demo.model.MstCountry;

public interface CountryService {

	void save(MstCountry country);
	List<MstCountry> findAll();

}
