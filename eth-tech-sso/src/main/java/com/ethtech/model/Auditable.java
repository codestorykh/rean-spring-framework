package com.ethtech.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable<U> implements Serializable {

    private static final long serialVersionUID = -4914303912805525802L;

    @Column(name = "created_by")
    @CreatedBy
    protected U createdBy;

    @Column(name = "creation_date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date creationDate;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    protected U lastModifiedBy;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;
}
