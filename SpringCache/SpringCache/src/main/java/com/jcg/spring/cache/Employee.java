package com.jcg.spring.cache;

import org.springframework.cache.annotation.Cacheable;

public class Employee  {

	private String emp_name = "";

	//This 'employeeCache' Is Declared In The 'ehcache.xml'
	@Cacheable(value="employeeCache") 
	public String getEmployeeName(int emp_id) {		
		if(emp_id == 101) {
			emp_name = "Java Code Geek";			
		} else {
			emp_name = "Daniel Atlas";
		}
		return emp_name;
	}
}