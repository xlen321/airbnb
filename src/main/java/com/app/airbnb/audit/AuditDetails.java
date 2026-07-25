package com.app.airbnb.audit;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditDetails {
  @CreatedBy
  @Column(
    name = "created_by", 
    updatable = false, 
    nullable = false
  )
  private String createdBy;

  @CreatedDate
  @Column(
    name = "created_at", 
    updatable = false, 
    nullable = false
  )
  private LocalDateTime createdAt;

  @LastModifiedBy
  @Column(
    name = "modified_by", 
    nullable = false
  )
  private String modifiedBy;

  @LastModifiedDate
  @Column(
    name = "modified_at", 
    nullable = false
  )
  private LocalDateTime modifiedAt;
}
