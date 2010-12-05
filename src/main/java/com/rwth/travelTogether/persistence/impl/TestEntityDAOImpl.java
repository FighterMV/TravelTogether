package com.rwth.travelTogether.persistence.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rwth.travelTogether.model.TestEntity;
import com.rwth.travelTogether.persistence.TestEntityDAO;

@Repository
public class TestEntityDAOImpl implements TestEntityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persist(TestEntity entity) {

		Session session = sessionFactory.getCurrentSession();

		session.persist(entity);
	}

}
