package com.example.demo.repository;

import com.example.demo.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarsRepo extends JpaRepository<Cars,Integer> {

    @Query(value="Select * from cars c where c.id =?1", nativeQuery=true)
    Cars findByIdTable(Integer id);

    @Query(value="select * from cars c where c.car_name like ?1", nativeQuery=true)
    List<Cars> findByName(String name);

}
