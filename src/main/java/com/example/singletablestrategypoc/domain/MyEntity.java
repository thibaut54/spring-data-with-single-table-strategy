package com.example.singletablestrategypoc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@Getter
@Setter
@Slf4j
@ToString
@Accessors(chain = true)
public class MyEntity extends MySuperEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

	private String name;
}
