package com.blinilab.javawebapp;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.blinilab.model.Employee;

import com.blinilab.service.EmployeeService;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	private EmployeeService employeeService;
	
	//Inject EmployeeService
	@Autowired(required=true)
    @Qualifier(value="employeeService")
    public void setPersonService(EmployeeService es){
        this.employeeService = es;
    }
	
	@RequestMapping(value= EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
    public @ResponseBody Employee createEmployee(@RequestBody Employee emp){
		logger.info("Start createEmployee.");
		this.employeeService.addEmployee(emp);
		return emp;
    }
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
    public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = this.employeeService.listEmployees();
		return emps;
    }
}
