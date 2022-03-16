package com.redis.cache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redis.cache.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee , Integer> {

}
