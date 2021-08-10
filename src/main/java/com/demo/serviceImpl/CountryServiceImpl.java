package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MstCountryDao;
import com.demo.model.MstCountry;
import com.demo.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private MstCountryDao mstCountryDao;
	
	
	@Override
	public void save(MstCountry country) {
		mstCountryDao.save(country);	
	}

	@Override
	public List<MstCountry> findAll() {
		return mstCountryDao.findAll();
	}

}
