package com.demo.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.MSTAddressDao;
import com.demo.model.MSTAddress;

@Transactional
@Repository
public class MSTAddressDaoImpl implements MSTAddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MSTAddress address) {
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public MSTAddress findByEmpId(Long id) {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MSTAddress> query = builder.createQuery(MSTAddress.class);
			Root<MSTAddress> root = query.from(MSTAddress.class);
			query.select(root).where(builder.equal(root.get("empId"), id));
			return sessionFactory.getCurrentSession().createQuery(query).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(MSTAddress address) {
		sessionFactory.getCurrentSession().update(address);
	}

	@Override
	public List<MSTAddress> findByEmpIds(List<Long> empIds) {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<MSTAddress> query = builder.createQuery(MSTAddress.class);
			Root<MSTAddress> root = query.from(MSTAddress.class);
			query.select(root).where(root.get("empId").in(empIds));
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
		}
		return null;
	}

}
