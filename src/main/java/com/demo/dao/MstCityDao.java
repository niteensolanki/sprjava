package com.demo.dao;

import java.util.List;

import com.demo.model.MstCity;

public interface MstCityDao {

	void save(MstCity city);

	List<MstCity> findByDisId(Long id);

}
