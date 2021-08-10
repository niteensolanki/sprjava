package com.demo.service;

import java.util.List;

import com.demo.model.MstState;

public interface StateService {

	void save(MstState country);

	List<MstState> findByCountryId(Long id);
	List<MstState> findAll();

}
