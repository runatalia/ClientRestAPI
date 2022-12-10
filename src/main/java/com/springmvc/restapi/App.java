package com.springmvc.restapi;

import com.springmvc.restapi.configuration.Config;
import com.springmvc.restapi.entity.Employee;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);
        System.out.println("All employees from JSON: ");
        List<Employee> employees = communication.getAllEmployees();
        System.out.println(employees);
        System.out.println("--------------------------------------------------------------------------------- ");
        System.out.println("Employee by ID: ");
        Employee employeeID = communication.getEployee(1);
        System.out.println(employeeID);
        System.out.println("--------------------------------------------------------------------------------- ");
        Employee emp = new Employee("Natalia", "Borodavitsina", "IT", 2000);
        emp.setId(1);
        communication.saveEployee(emp);
        System.out.println("--------------------------------------------------------------------------------- ");
        communication.deleteEployee(4);
        context.registerShutdownHook();
    }
}
