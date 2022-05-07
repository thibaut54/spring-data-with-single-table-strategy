package com.example.singletablestrategypoc.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();
}
