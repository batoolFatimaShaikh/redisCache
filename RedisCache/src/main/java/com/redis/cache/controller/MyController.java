package com.redis.cache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.cache.model.Employee;
import com.redis.cache.service.IService;

@RestController
@RequestMapping("/employee")
public class MyController {
	@Autowired
	private IService service;
	
     @PostMapping("/save")
	public Employee saveEmp(@RequestBody Employee employee) {
		return service.saveEmp(employee);
	}
     @GetMapping("/all")
     public ResponseEntity<List<Employee>> getAllEmp(){
    	 return ResponseEntity.ok(service.getAllEmp());	 
     }
     @GetMapping("/one/{empId}")
     public Optional<Employee> getOneEmp(@PathVariable Integer empId ) {
    	return service.getOneEmp(empId);
     }
     
     @PutMapping("/modify/{empId}")
     public Employee updateEmp(@PathVariable Integer empId,
    		 					@RequestBody Employee employee) {
    	 Employee emp =service.updateEmp(empId,employee);
    	 return emp;
     }
     
     @DeleteMapping("/delete/{empId}")
     public String deleteEmp(@PathVariable Integer empId) {
    	service.delEmp(empId);
    	 return "Empolyee deleted=>"+empId;
     }
}
