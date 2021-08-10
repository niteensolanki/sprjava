package com.demo.service;

import java.util.List;

import com.demo.model.MstDistict;

public interface DistService {

	void save(MstDistict country);
	
	List<MstDistict> findByStateId(Long id);
	
	List<MstDistict> findAll();

}
