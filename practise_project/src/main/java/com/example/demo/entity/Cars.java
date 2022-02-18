package com.example.demo.entity;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cars implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARS_SEQ_GEN")
    @SequenceGenerator(name = "CARS_SEQ_GEN", sequenceName = "SEQ_CARS")
    private Integer id;

    @Column(name = "car_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", foreignKey = @ForeignKey(name = "FK_cars_model_MODEL"))
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "FK_person"))
    private Person person;


    //    @JoinColumns({
//            @JoinColumn(name="ADDR_ID", referencedColumnName="ID"),
//            @JoinColumn(name="ADDR_ZIP", referencedColumnName="ZIP")
//    })
//    private Referencetable referencetable;


}
