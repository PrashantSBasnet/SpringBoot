package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ_GEN")
    @SequenceGenerator(name="PERSON_SEQ_GEN", sequenceName = "SEQ_PERSON")
    private Integer id;
    private String name;
    private String address;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cars_id", foreignKey = @ForeignKey(name = "FK_person_cars"))
    List<Cars> cars;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", foreignKey = @ForeignKey(name = "FK_cars_orders"))
    List<Orders> orders;


}
