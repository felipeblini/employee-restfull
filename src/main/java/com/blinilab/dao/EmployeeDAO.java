package com.blinilab.dao;

import java.util.List;

import com.blinilab.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee emp);

	public List<Employee> listEmployees();

	public String empAddress();

	public String age();

}