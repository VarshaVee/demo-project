package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.ServiceResp;
import com.example.demo.service.EmpService;



@RestController
@RequestMapping("employee")
public class Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public EmpService service;
	
	@PostMapping("/add")
	public ResponseEntity<ServiceResp> addEmp(@RequestBody Employee emp) {
		logger.info("Invoking method to add new employee.");
		ServiceResp serviceResp = service.addEmp(emp);
		return new ResponseEntity<ServiceResp>(serviceResp, HttpStatus.valueOf(serviceResp.getStatusCode()));
	}
	
	@GetMapping(value = "/employees")
	public ResponseEntity <ServiceResp> getAllemployees() {
		logger.info("Invoking method to get all employees");
		ServiceResp serviceStatus = service.getAllemployees();
		return new ResponseEntity<ServiceResp>(serviceStatus, HttpStatus.valueOf(serviceStatus.getStatusCode()));
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity <ServiceResp> getEmpById(@PathVariable Integer id) {
		logger.info("Invoking method to get employee by id ");
		ServiceResp serviceResp = service.getEmpById(id);
		return new ResponseEntity<ServiceResp>(serviceResp, HttpStatus.valueOf(serviceResp.getStatusCode()));
	}
	
	@PutMapping(value="update/{id}")
	public ResponseEntity<ServiceResp> updateEmp(@PathVariable int id,@RequestBody Employee emp) {
		logger.info(" Invoking API for update the details");
		ServiceResp serviceResp = service.updateemployee(emp,id);		
		return new ResponseEntity<ServiceResp>(serviceResp, HttpStatus.valueOf(serviceResp.getStatusCode()));
	}

	@GetMapping(value = "/salary/{id}")
	public ResponseEntity <ServiceResp> getSalaryDetails(@PathVariable Integer id) {
		logger.info("Invoking method to get salary details");
		ServiceResp serviceStatus = service.getSalaryDetails(id);
		return new ResponseEntity<ServiceResp>(serviceStatus, HttpStatus.valueOf(serviceStatus.getStatusCode()));
	}

}
