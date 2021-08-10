package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.MstDistictDao;
import com.demo.model.MstDistict;
import com.demo.service.DistService;

@Service
public class DistServiceImpl implements DistService {

	@Autowired
	private MstDistictDao disDao;

	@Override
	public void save(MstDistict country) {
		disDao.save(country);
	}

	@Override
	public List<MstDistict> findByStateId(Long id) {
		return disDao.findByStateId(id);
	}

	@Override
	public List<MstDistict> findAll() {
		// TODO Auto-generated method stub
		return disDao.findAll();
	}

}
