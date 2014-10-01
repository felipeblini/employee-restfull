package com.blinilab.service;

import java.util.List;

import com.blinilab.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp);
    public List<Employee> listEmployees();
}
