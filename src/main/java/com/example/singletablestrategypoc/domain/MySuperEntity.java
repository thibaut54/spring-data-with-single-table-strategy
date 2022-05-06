package com.example.singletablestrategypoc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Getter
@Setter
@ToString
public class MySuperEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1, allocationSize = 100)
//	@GeneratedValue(generator = "mySeqGen")
	private Long id;
}
