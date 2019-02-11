package com.jcg.spring.cache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	static int emp_id;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext  contextObj = new AnnotationConfigApplicationContext ();
		contextObj.register(SpringConfig.class);
		contextObj.refresh();

		Employee empObj = (Employee) contextObj.getBean(Employee.class);

		// Calling 'getEmployeeName' Method For The First Time.
		emp_id = 101;
		System.out.println("Fetching Employee Name With Id?= " + emp_id);
		System.out.println("Name?= " + empObj.getEmployeeName(emp_id));

		// Calling 'getEmployeeName' Method For The Second Time & This Time Method Will Not Execute As Result Will Be Fetched From Cache.
		System.out.println("\n!--- Again Fetching Employee Name With Id?= " + emp_id + ". Result Will Be Fetched From The Cache ---!");
		System.out.println("Name?= " + empObj.getEmployeeName(emp_id));

		// Calling 'getEmployeeName' Method For The Third Time With A Different Value.
		emp_id = 102;
		System.out.println("\nFetching Employee Name With Id?= " + emp_id);
		System.out.println("Name?= " + empObj.getEmployeeName(emp_id));

		// Closing The Spring Context.
		contextObj.close();
	}
}