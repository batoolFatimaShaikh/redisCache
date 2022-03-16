package com.redis.cache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.cache.exception.ResourceNotFound;
import com.redis.cache.model.Employee;
import com.redis.cache.repo.EmpRepository;

@Service
public class ServiceImpl implements IService {
	
	@Autowired
	private EmpRepository repo;
	
	@Override
	public Employee saveEmp(Employee e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

	@Override
	@CachePut(/*key = "#empId",*/value = "employee")
	public Employee updateEmp(Integer empId, Employee e) {
		Employee emp=repo.findById(empId)
				.orElseThrow(()-> new ResourceNotFound("Employee not exit"));
		emp.setEmpName(e.getEmpName());
		emp.setEmpSal(e.getEmpSal());
		
		return repo.save(emp);
	}

	@Override
	@CacheEvict(allEntries = true ,value = "employee")
	public void delEmp(Integer Id) {
		Employee emp=repo.findById(Id)
				.orElseThrow(()-> new ResourceNotFound("Employee not exit"));
		repo.delete(emp);
	}
	
	
	@Override
	@Cacheable(value="employee" )
	public Optional<Employee> getOneEmp(Integer Id) {
		Employee emp=repo.findById(Id)
				.orElseThrow(()-> new ResourceNotFound("Employee not exit"));
		
		return Optional.of(emp);
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return repo.findAll();
	}

}
