package com.demo.dao;

import java.util.List;

import com.demo.model.MSTAddress;

public interface MSTAddressDao {

	void save(MSTAddress address);

	MSTAddress findByEmpId(Long id);

	void update(MSTAddress address);

	List<MSTAddress> findByEmpIds(List<Long> empIds);

}
