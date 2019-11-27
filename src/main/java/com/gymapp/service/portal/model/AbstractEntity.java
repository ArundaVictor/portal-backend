package com.gymapp.service.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.envers.Audited;
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
@Audited
public class AbstractEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9116576151473381175L;

    @Id
    @JsonProperty("id")
    @Column(name = "id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("uuid")
    @Column(name = "uuid", unique=true, nullable=false, length=36)
    private String uuid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }




}
