package com.global.shopserver.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 추후에 엔티티가 상속받아 편하게 사용할 수 있게 하기 위함
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity { // 생성일자, 수정일자를 담는 추상 클래스

    @CreatedDate
    @Column(updatable = false) // 한 번 생성이 되고 나서는 수정되면 안된다
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
