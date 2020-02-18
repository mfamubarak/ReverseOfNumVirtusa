package com.ahamed.myspringapp.resource;

import com.ahamed.myspringapp.model.Employee;
import com.ahamed.myspringapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/rest/users")
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employs", produces = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.GET)
    public List<Employee> getAllEmployeesXML(){
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/employeess", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<Employee> getAllEmployeesJSON()
    {
    	 return employeeRepository.findAll();
    }


    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.GET)
    public Employee find(Employee employee) {
        Optional<Employee> employee1=employeeRepository.findById(employee.getId());
       if(employee1.isPresent()){
           return employee;
       }
       else
           return null;
    }

    @GetMapping(value="/all")
     public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @PostMapping(value="/load")
    public List<Employee> persist(@RequestBody final Employee employee){

        employeeRepository.save(employee);
        return employeeRepository.findAll();
    }

}
