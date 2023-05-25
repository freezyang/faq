package com.faq.core.jpa.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity {

    private Long createdBy;

    @CreatedDate
    private ZonedDateTime createdDt;

    private Long modifiedBy;

    @LastModifiedDate
    private ZonedDateTime modifiedDt;
}
