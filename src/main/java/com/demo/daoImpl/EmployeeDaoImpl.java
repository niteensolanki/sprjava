package com.demo.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long save(Employee employee) {
		return (Long) sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public Employee findById(Long id) {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			Root<Employee> root = query.from(Employee.class);
			query.select(root).where(builder.equal(root.get("id"), id));
			return sessionFactory.getCurrentSession().createQuery(query).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}

	@Override
	public List<Employee> findAll() {
		try {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			Root<Employee> root = query.from(Employee.class);
			query.select(root);
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
