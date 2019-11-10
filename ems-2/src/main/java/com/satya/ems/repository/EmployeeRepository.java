package com.satya.ems.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.satya.ems.entity.Employee;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}

