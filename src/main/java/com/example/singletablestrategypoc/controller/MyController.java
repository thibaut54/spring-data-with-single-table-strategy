package com.example.singletablestrategypoc.controller;

import com.example.singletablestrategypoc.domain.MyEntity;
import com.example.singletablestrategypoc.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

	private final MyService<MyEntity> myService;

	@GetMapping(value = "entity/default/{id}")
	public String getEntityDefaultById(@PathVariable Long id){
		return myService.getEntityDefaultById(id, MyEntity.class).getName();
	}

	@GetMapping(value = "entity/A/{id}")
	public String getEntityAById(@PathVariable Long id){
		return myService.getEntityAById(id, MyEntity.class).getName();
	}

	@GetMapping(value = "entity/root/{id}")
	public String getEntityById(@PathVariable Long id){
		return myService.getEntityById(id, MyEntity.class).getName();
	}
}
