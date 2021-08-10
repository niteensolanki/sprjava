package com.demo.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.MstCityDao;
import com.demo.model.MstCity;

@Transactional
@Repository
public class MstCityDaoImpl implements MstCityDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MstCity city) {
		sessionFactory.getCurrentSession().persist(city);
	}

	@Override
	public List<MstCity> findByDisId(Long id) {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MstCity> query = builder.createQuery(MstCity.class);
			Root<MstCity> root = query.from(MstCity.class);
			query.select(root).where(builder.equal(root.get("distId"), id));
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
