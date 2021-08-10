package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MstCityDao;
import com.demo.model.MstCity;
import com.demo.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private MstCityDao cityDao;

	@Override
	public void save(MstCity city) {
		cityDao.save(city);
	}

	@Override
	public List<MstCity> findByDisId(Long id) {
		return cityDao.findByDisId(id);
	}

}
