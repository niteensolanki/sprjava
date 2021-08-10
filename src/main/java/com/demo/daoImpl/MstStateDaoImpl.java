package com.demo.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.MstStateDao;
import com.demo.model.MstCountry;
import com.demo.model.MstState;

@Transactional
@Repository
public class MstStateDaoImpl implements MstStateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MstState country) {
		sessionFactory.getCurrentSession().persist(country);
	}

	@Override
	public List<MstState> findByCountryId(Long id) {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MstState> query = builder.createQuery(MstState.class);
			Root<MstState> root = query.from(MstState.class);
			query.select(root).where(builder.equal(root.get("countryId"), id));
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MstState> findAll() {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MstState> query = builder.createQuery(MstState.class);
			Root<MstState> root = query.from(MstState.class);
			query.select(root);
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	



	

}
