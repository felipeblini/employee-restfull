package com.blinilab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

import com.blinilab.dao.EmployeeDAO;
import com.blinilab.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	 
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
 
    @Override
    @Transactional
    public void addEmployee(Employee emp) {
        this.employeeDAO.addEmployee(emp);
    }
 
    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return this.employeeDAO.listEmployees();
    }
}
