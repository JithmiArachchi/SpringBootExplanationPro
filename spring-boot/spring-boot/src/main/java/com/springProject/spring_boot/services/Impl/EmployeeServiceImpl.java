package com.springProject.spring_boot.services.Impl;

import com.springProject.spring_boot.dto.EmployeeDto;
import com.springProject.spring_boot.entity.Employee;
import com.springProject.spring_boot.repo.EmployeeRepo;
import com.springProject.spring_boot.services.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeRepo employeeRepo;

    // inject by constuctor injection
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // 03 - set data from DTOs to Entities
    @Override
    public EmployeeDto saveEmployee(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
// 04 - then send it to Repo via Entity
        Employee saveEmp = employeeRepo.save(employee);

        //07 ** - convert Entity data to response DTO
        EmployeeDto saveEmployeeDto = new EmployeeDto();
        saveEmployeeDto.setId(saveEmp.getId());  // set dto from entity get data
        saveEmployeeDto.setEmail(saveEmp.getEmail());
        saveEmployeeDto.setPhone(saveEmp.getPhone());
        saveEmployeeDto.setName(saveEmp.getName());

        // 08 ** - return DTO data and send to Controller
        return saveEmployeeDto;
    }
}
