package com.example.singletablestrategypoc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class MyEntityB extends MyEntity{
	private String city;

}
