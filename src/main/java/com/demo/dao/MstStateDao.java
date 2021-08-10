package com.demo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.MstCountry;
import com.demo.model.MstState;

public interface MstStateDao {
	
	
	void save(MstState country);

	List<MstState> findByCountryId(Long id);

	List<MstState> findAll(); 
	


	
	

}
