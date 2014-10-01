package com.blinilab.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.blinilab.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addEmployee(Employee emp) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(emp );
        logger.info("Employee saved successfully, Employee Details="+emp);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeessList = session.createQuery("from employee").list();
        for(Employee emp : employeessList){
            logger.info("Employee List::"+emp);
        }
        return employeessList;
    }
    
}
