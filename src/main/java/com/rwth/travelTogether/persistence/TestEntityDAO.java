package com.rwth.travelTogether.persistence;

import java.util.List;

import com.rwth.travelTogether.model.TestEntity;


public interface TestEntityDAO {

	void persist(TestEntity entity);

	List<TestEntity> get(String name);

	TestEntity get(Long id);
}
