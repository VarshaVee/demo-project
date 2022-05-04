package com.example.demo.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.Employee;
import com.example.demo.model.ServiceResp;
import com.example.demo.repository.EmpRepo;

@Service
public class EmpService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public EmpDao empDao;
	
	@Autowired
	public EmpRepo empRepo;
	
	public ServiceResp addEmp(Employee emp) {
		ServiceResp serviceResp = new ServiceResp();
		try{
			Employee empResp = empDao.addEmp(emp);
			serviceResp.setStatus("Success");
			serviceResp.setStatusCode(200);
			serviceResp.setMessage("Employee has been added successfully.");
			serviceResp.setResp(empResp);
			logger.info(serviceResp.getMessage()+" with id::"+emp.getId());
		}catch(Exception e){
			serviceResp.setStatus("Failed");
			serviceResp.setStatusCode(500);
			serviceResp.setMessage("Failed to add employee!!");
			logger.error(serviceResp.getMessage()+" with id::"+emp.getId()+" due to "+e.getMessage());
		}
		return serviceResp;
	}

	public ServiceResp getAllemployees() {
		ServiceResp serviceResp = new ServiceResp();
		try{
			List<Employee> empResp = empDao.getAllemployees();
			serviceResp.setStatus("Success");
			serviceResp.setStatusCode(200);
			serviceResp.setResp(empResp);
			serviceResp.setMessage("Successfully got the employees!!");
			logger.info(serviceResp.getMessage());
		}catch(Exception e){
			serviceResp.setStatus("Failed");
			serviceResp.setStatusCode(500);
			serviceResp.setMessage("Failed to get clients!!");
			logger.error(serviceResp.getMessage()+" due to "+e.getMessage());
		}
		return serviceResp;
	}
	
	public ServiceResp getEmpById(Integer id) {
		ServiceResp serviceResp = new ServiceResp();
		try{
			Employee e = empDao.findById(id);
			serviceResp.setStatus("Success");
			serviceResp.setStatusCode(200);
			serviceResp.setResp(e);
			serviceResp.setMessage("Successfully got employee by Id !!");
			logger.info(serviceResp.getMessage()+" with id::"+e.getId());
		}catch(Exception e){
			serviceResp.setStatus("Failed");
			serviceResp.setStatusCode(500);
			serviceResp.setMessage("Failed to get employee by id !!");
			logger.error(serviceResp.getMessage()+" due to "+e.getMessage());
		}
		return serviceResp;
	}

	public ServiceResp updateemployee(Employee emp,int id) {
		ServiceResp serviceResp = new ServiceResp();
		try {
			Employee e = empDao.findById(id);
			if(e.getId() == null){
				serviceResp.setStatus("Failed");
				serviceResp.setStatusCode(417);
				serviceResp.setMessage("Employee id should not be null.");
				return serviceResp;
			}
		else {
			e.setId(emp.getId());
			e.setName(emp.getName());
			e.setAddress(emp.getAddress());
			e.setSalary(emp.getSalary());
			e.setPfpercentage(emp.getPfpercentage());
			e.setCompanyId(emp.getCompanyId());
		    empDao.save(emp.getId());
		    return serviceResp;
			}
		}
		catch(Exception e){
			logger.error("Failed to Process the details due to "+e.getMessage());
			serviceResp.setStatus("Fail");
			serviceResp.setStatusCode(500);
			serviceResp.setMessage("Failed to Process the details");
			serviceResp.setErrorMessage(e.getMessage());
		}
		return serviceResp;
		    
	}


	public ServiceResp getSalaryDetails(int id) {
		ServiceResp serviceResp = new ServiceResp();
		double netsalary = 0;
		double pfamount = 0;
		try {
			Employee e = empDao.findById(id);
			if(e.getId() == null){
				serviceResp.setStatus("Failed");
				serviceResp.setStatusCode(417);
				serviceResp.setMessage("Employee id should not be null.");
				return serviceResp;
			}
			else {
				if((e.getSalary()>0) && (e.getPfpercentage()>=0)) {
				    pfamount = (e.getSalary()*e.getPfpercentage())/100;
				    netsalary = e.getSalary()-pfamount;
				    serviceResp.setResp(e);
				    return serviceResp;
					}
			}
		}catch(Exception e){
			logger.error("Failed to Process the details due to "+e.getMessage());
			serviceResp.setStatus("Fail");
			serviceResp.setStatusCode(500);
			serviceResp.setMessage("Failed to Process the details");
			serviceResp.setErrorMessage(e.getMessage());
		}
			return serviceResp;
		}
			
}
	



