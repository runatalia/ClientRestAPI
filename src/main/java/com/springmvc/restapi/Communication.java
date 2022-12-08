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

    public Employee getEployee() {
        return null;
    }

    public void saveEployee() {
    }

    public void deleteEployee() {
    }

}
