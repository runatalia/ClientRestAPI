package com.springmvc.restapi;

import com.springmvc.restapi.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;  //DI with bean RestTemplate
    private final String URL = "http://localhost:8080/api/employees";           //url for call 

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
        });  //made a GET request to URL, sending HTTP headers that are wrapped in an HttpEntity instance.
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEployee(int id) {   //get Employee by id
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class); //send a request to the URL and wait for a response Employee
        return employee;
    }

    public void saveEployee(Employee employee) {   //saving and updating a worker
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employeewith ID " + id + " was  updated");
        }
    }

    public void deleteEployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted from DB");
    }

}
