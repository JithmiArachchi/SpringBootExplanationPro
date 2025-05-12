package com.springProject.spring_boot.services;

import com.springProject.spring_boot.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeService {
    //02 - send to service IMPL as DTO
    EmployeeDto saveEmployee(EmployeeDto dto);
}
