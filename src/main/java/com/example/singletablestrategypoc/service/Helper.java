package com.example.singletablestrategypoc.service;

import com.example.singletablestrategypoc.domain.MyEntity;
import com.example.singletablestrategypoc.domain.MyEntityDefault;
import com.example.singletablestrategypoc.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Helper {

	private final MyRepository<MyEntity> myEntityMyRepository;
	private final MyService<MyEntity>  myService;


	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		final MyEntityDefault entityDefaultById = myEntityMyRepository.getEntityDefaultById(2L);

		final MyEntity entityDefaultById1 = myService.getEntityDefaultById(2L, MyEntity.class);
		final MyEntity entityAById = myService.getEntityAById(3L, MyEntity.class);

		log.info("Entity default without specialized type retrieved: {}", entityDefaultById);
		log.info("Entity default with specialized type retrieved: {}", entityDefaultById1);
		log.info("Entity A retrieved: {}", entityAById);

//		final MyEntityA myEntity = new MyEntityA();
//		myEntity.setName("Jean");
//		myEntity.setAge("25");
//		myService.save(myEntity, MyEntity.class);
	}
}
