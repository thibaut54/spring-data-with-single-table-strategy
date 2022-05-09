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
@DiscriminatorValue("Default")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class MyEntityDefault extends MyEntity{
	private String country;
}
