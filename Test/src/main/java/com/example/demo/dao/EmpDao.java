package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepo;

@Repository
public class EmpDao {

	@Autowired
	EmpRepo empRepo;
	
	
	public Employee addEmp(Employee emp) {
		return empRepo.save(emp);
	
	}	

	public List<Employee> getAllemployees() {
		return empRepo.findAll();
	}


	public Employee findById(int id) {
		return empRepo.findById(id).get();
	}


	public void save(Integer id) {
		// TODO Auto-generated method stub
		
	}


	

}