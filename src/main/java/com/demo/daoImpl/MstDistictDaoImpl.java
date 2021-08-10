package com.demo.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.MstDistictDao;
import com.demo.model.MstCountry;
import com.demo.model.MstDistict;

@Transactional
@Repository
public class MstDistictDaoImpl implements MstDistictDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MstDistict country) {
		sessionFactory.getCurrentSession().persist(country);
	}

	@Override
	public List<MstDistict> findByStateId(Long id) {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MstDistict> query = builder.createQuery(MstDistict.class);
			Root<MstDistict> root = query.from(MstDistict.class);
			query.select(root).where(builder.equal(root.get("stateId"), id));
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MstDistict> findAll() {
	
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MstDistict> query = builder.createQuery(MstDistict.class);
			Root<MstDistict> root = query.from(MstDistict.class);
			query.select(root);
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
