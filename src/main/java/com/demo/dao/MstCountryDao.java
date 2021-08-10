package com.demo.dao;

import java.util.List;

import com.demo.model.MstCountry;

public interface MstCountryDao {

	void save(MstCountry country);

	List<MstCountry> findAll();

}
