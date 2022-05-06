package com.example.singletablestrategypoc.repository;

import com.example.singletablestrategypoc.domain.MyEntity;
import com.example.singletablestrategypoc.domain.MyEntityDefault;
import com.example.singletablestrategypoc.domain.MySuperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyRepository<T extends MySuperEntity> extends JpaRepository<T, Long> {

	@Query("select e from MyEntityDefault e where e.id= :id")
	MyEntityDefault getEntityDefaultById(@Param("id") Long id);

	@Query("select e from MyEntityA e where e.id= :id")
	MyEntity getEntityAById(@Param("id") Long id);

	@Query("select e from MyEntity e where e.id= :id")
	MyEntity getEntityById(@Param("id") Long id);
}
