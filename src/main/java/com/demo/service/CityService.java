package com.demo.service;

import java.util.List;

import com.demo.model.MstCity;

public interface CityService {

	void save(MstCity country);

	List<MstCity> findByDisId(Long id);
}
