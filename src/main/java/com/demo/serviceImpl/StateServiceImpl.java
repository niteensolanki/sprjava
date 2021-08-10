package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MstStateDao;
import com.demo.model.MstCountry;
import com.demo.model.MstState;
import com.demo.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private MstStateDao stateDao;

	@Override
	public void save(MstState country) {
		stateDao.save(country);
	}

	@Override
	public List<MstState> findByCountryId(Long id) {
		return stateDao.findByCountryId(id);
	}

	@Override
	public List<MstState> findAll() {
		return stateDao.findAll();
	}

	

}
