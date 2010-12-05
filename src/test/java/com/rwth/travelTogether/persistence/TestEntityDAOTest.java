package com.rwth.travelTogether.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rwth.travelTogether.model.TestEntity;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@TransactionConfiguration()
@Transactional
public class TestEntityDAOTest extends TestCase {

	@Autowired
	private TestEntityDAO instance;

	@Test
	public void testPersist() {

		TestEntity entity = new TestEntity();
		entity.setTestString("bablabla");

		instance.persist(entity);

		assertNotNull(entity.getId());
	}
}
