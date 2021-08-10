package com.demo.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.MstCountryDao;
import com.demo.model.MstCountry;

@Transactional
@Repository
public class MstCountryDaoImpl implements MstCountryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MstCountry country) {
		sessionFactory.getCurrentSession().persist(country);
	}

	@Override
	public List<MstCountry> findAll() {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MstCountry> query = builder.createQuery(MstCountry.class);
			Root<MstCountry> root = query.from(MstCountry.class);
			query.select(root);
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
