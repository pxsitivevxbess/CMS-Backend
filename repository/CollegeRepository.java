package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Colleges;
@Repository
//We have to specify the name of table and Object Data type of Primary Key we can't write int we need to write object type of int i.e Integer
public interface CollegeRepository extends JpaRepository<Colleges, Long>{

}
