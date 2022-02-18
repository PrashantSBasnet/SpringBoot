package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data

@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ_base")
    @SequenceGenerator(name="SEQ_base", sequenceName = "BASE_ENTITY_SEQ")
    private Integer id;
    private Integer status;

    @CreatedDate
    @Column(name = "createdDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updatedDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate;

}
