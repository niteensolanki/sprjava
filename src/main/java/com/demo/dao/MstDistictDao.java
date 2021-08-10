package com.demo.dao;

import java.util.List;

import com.demo.model.MstDistict;

public interface MstDistictDao {

	void save(MstDistict country);

	List<MstDistict> findByStateId(Long id);
	List<MstDistict> findAll();

}
