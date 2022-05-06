package com.example.singletablestrategypoc.service;

import com.example.singletablestrategypoc.domain.MyEntity;
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
public class MyService {

	private final MyRepository<MyEntity> myEntityMyRepository;

	public MySuperEntity save(final MyEntity myEntity){
		return myEntityMyRepository.save(myEntity);
	}

	public MyEntity getById(final Long id){
		return myEntityMyRepository.getById(id);
	}

	public MyEntity getEntityDefaultById(final Long id){
		return myEntityMyRepository.getEntityDefaultById(id);
	}

	public MyEntity getEntityAById(final Long id){
		return myEntityMyRepository.getEntityAById(id);
	}

	public MyEntity getEntityById(final Long id){
		return myEntityMyRepository.getEntityById(id);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		final MyEntityDefault entityDefaultById = myEntityMyRepository.getEntityDefaultById(2L);

		final MyEntity entityDefaultById1 = getEntityDefaultById(2L);
		final MyEntity entityAById = getEntityAById(3L);

		log.info("Entity default without specialized type retrieved: {}", entityDefaultById);
		log.info("Entity default with specialized type retrieved: {}", entityDefaultById1);
		log.info("Entity A retrieved: {}", entityAById);
	}
}
