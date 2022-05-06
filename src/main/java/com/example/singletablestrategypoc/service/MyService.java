package com.example.singletablestrategypoc.service;

import com.example.singletablestrategypoc.domain.MyEntity;
import com.example.singletablestrategypoc.domain.MyEntityA;
import com.example.singletablestrategypoc.domain.MyEntityDefault;
import com.example.singletablestrategypoc.domain.MySuperEntity;
import com.example.singletablestrategypoc.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyService/*<T extends MySuperEntity>*/ {

	private final MyRepository<MyEntity> myEntityMyRepository;

//	public <T extends MySuperEntity> T save(final T myEntity, Class<T> entityType){
//		final T cast = entityType.cast(myEntity);
//		final S save = myEntityMyRepository.save(cast);
//		return entityType.cast(save);
//	}

//	public T getById(final Long id){
//		return myEntityMyRepository.getById(id);
//	}

	public <T extends MySuperEntity> T getEntityDefaultById(final Long id, Class<T> entityType){
		return entityType.cast(myEntityMyRepository.getEntityDefaultById(id));
	}

	public <T extends MySuperEntity> T getEntityAById(final Long id, Class<T> entityType){
		return entityType.cast(myEntityMyRepository.getEntityAById(id));
	}

	public<T extends MySuperEntity> T getEntityById(final Long id, Class<T> entityType){
		return entityType.cast(myEntityMyRepository.getEntityById(id));
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		final MyEntityDefault entityDefaultById = myEntityMyRepository.getEntityDefaultById(2L);

		final MyEntity entityDefaultById1 = getEntityDefaultById(2L, MyEntity.class);
		final MyEntity entityAById = getEntityAById(3L, MyEntityA.class);

		log.info("Entity default without specialized type retrieved: {}", entityDefaultById);
		log.info("Entity default with specialized type retrieved: {}", entityDefaultById1);
		log.info("Entity A retrieved: {}", entityAById);
	}
}
