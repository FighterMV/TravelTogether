package com.rwth.travelTogether.persistence.impl;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public List<TestEntity> get(String name) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("select myAlias from TestEntity myAlias where myAlias.name = :name");
		query.setString("name", name);

		return query.list();
	}

	@Override
	public TestEntity get(Long id) {

		Session session = sessionFactory.getCurrentSession();
		return (TestEntity) session.get(TestEntity.class, id);
	}

}
