package com.example.singletablestrategypoc.service;

import com.example.singletablestrategypoc.domain.MySuperEntity;
import com.example.singletablestrategypoc.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyService<T extends MySuperEntity> {

	private final MyRepository<MySuperEntity> myEntityMyRepository;

	public T save(final T myEntity, Class<T> entityType){
		final T cast = entityType.cast(myEntity);
		return myEntityMyRepository.save(cast);
	}

	public T getEntityDefaultById(final Long id, Class<T> entityType){
		return entityType.cast(myEntityMyRepository.getEntityDefaultById(id));
	}

	public T getEntityAById(final Long id, Class<T> entityType){
		return entityType.cast(myEntityMyRepository.getEntityAById(id));
	}

	public T getEntityById(final Long id, Class<T> entityType){
		return entityType.cast(myEntityMyRepository.getEntityById(id));
	}
}
