package com.redis.cache.service;

import java.util.List;
import java.util.Optional;

import com.redis.cache.model.Employee;



public interface IService {
	public Employee saveEmp(Employee e);
	public Employee updateEmp(Integer empId,Employee e);
	public void delEmp(Integer id);
	
	public Optional<Employee> getOneEmp(Integer id);
	public List<Employee> getAllEmp();
	
}
