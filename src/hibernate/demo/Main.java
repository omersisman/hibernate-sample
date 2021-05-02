package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Employee;


public class Main {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
				
		try {
			
			
			//code snippet to save objects to database
			//create a student object
			System.out.println("Creating new employee object...");
			Employee tempEmployee = new Employee("Paul", "Wall", "amazon");
					
			//start a transaction
			session.beginTransaction();
					
			//save the employee object
			System.out.println("Saving the employee...");
			session.save(tempEmployee);
					
			//commit transaction
			session.getTransaction().commit();
					
			System.out.println("Done!");
			
			
			/*
			 * code snippet to retrieve object from database by primary key
			 * uncomment to use
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id: primary key
			System.out.println("\nGetting student with id: " + 1);
			
			Employee myStudent = session.get(Employee.class, 1);
			
			System.out.println("Get complete: " + myStudent);
			
			//commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			*/
			
			/*
			 * code snippet to query objects
			 * uncomment to use
			//start a transaction
			session.beginTransaction();
			
			//query employees
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			//display the employees
			displayEmployees(theEmployees);
			
			//query employees: lastName='Doe'
			theEmployees = session.createQuery("from Employee e where e.lastName='Doe'").getResultList();
			
			//display the employees
			System.out.println("\nEmployees who have last name of Doe");
			displayEmployees(theEmployees);
			
			//query employees: lastName='Doe' OR firstName='Daffy'
			theEmployees = session.createQuery("from Employee e where e.lastName='Doe' OR e.firstName='Daffy'").getResultList();
			System.out.println("\nEmployees who have last name of Doe or first name of Daffy");
			displayEmployees(theEmployees);
			
			//query employees where company LIKE '%tech'
			theEmployees = session.createQuery("from Employee e where e.company LIKE '%tech'").getResultList();
			System.out.println("\nEmployees who have company ends with tech");
			displayEmployees(theEmployees);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			*/
			
			
			/*
			 * code snippet to delete the objects
			 * uncomment to use
			int employeeId = 1;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve employee based on id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			//delete the employee
			System.out.println("Deleting employee: " + myEmployee);
			session.delete(myEmployee);
			
			//delete employee id=2
			//System.out.println("Deleting employee id=2");
			//session.createQuery("delete from Employee where id=2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			*/
		}
		
		finally {
					
			factory.close();
					
		}
		
		
	}
	
	//helper method to print list of employee objects
	private static void displayEmployees(List<Employee> theEmployees) {
		for(Employee e :  theEmployees) {
			System.out.println(e);
		}
	}

}
