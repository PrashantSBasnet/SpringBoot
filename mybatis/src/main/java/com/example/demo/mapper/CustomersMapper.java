package com.example.demo.mapper;

import com.example.demo.models.Customers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface CustomersMapper {

    @Select("select * from customer_table")
    List<Customers> getAll();

    @Insert("insert into customer_table ( id, name, address) values (#{id}, #{name}, #{address})")
    //@SelectKey(statement = "Select LAST_INSERT_ID()", keyProperty = "id",
    //before = false, resultType = Integer.class)
    void insert(Customers customers);


}
