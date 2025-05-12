package com.springProject.spring_boot.services;

import com.springProject.spring_boot.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {
    // ** all the methods in the interfaces are abstract methods : this is like a Content of a service

    //02 - send to service IMPL as DTO
    EmployeeDto saveEmployee(EmployeeDto dto);


    List<EmployeeDto> getAllEmployees();

    EmployeeDto deleteEmployee(Integer id);

    EmployeeDto getEmployeeById(Integer id);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id);

    EmployeeDto saveEmployeeModelMapper(EmployeeDto dto);
}
