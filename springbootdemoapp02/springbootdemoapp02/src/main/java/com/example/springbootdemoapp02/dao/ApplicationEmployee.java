package com.example.springbootdemoapp02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootdemoapp02.dto.Employee;

@Repository
public interface ApplicationEmployee extends JpaRepository<Employee,Long>{
	

}
