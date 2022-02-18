package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "model")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Model extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CarModel_SEQ_GEN")
    @SequenceGenerator(name = "CarModel_SEQ_GEN", sequenceName = "SEQ_CARS_MODEL")
    private Integer id;

    @Column(name = "model_name")
    private String name;

    @Column(name = "model_year")
    private Date model_year;
}
