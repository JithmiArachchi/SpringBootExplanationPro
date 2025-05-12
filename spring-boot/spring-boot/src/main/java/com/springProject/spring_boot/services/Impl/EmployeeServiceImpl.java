package com.springProject.spring_boot.services.Impl;

import com.springProject.spring_boot.dto.EmployeeDto;
import com.springProject.spring_boot.entity.Employee;
import com.springProject.spring_boot.repo.EmployeeRepo;
import com.springProject.spring_boot.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    ModelMapper modelMapper;
    public EmployeeRepo employeeRepo;

    // inject by constuctor injection -- (recommended )
    public EmployeeServiceImpl(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
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

    @Override
    public EmployeeDto saveEmployeeModelMapper(EmployeeDto dto) {

        // *#*#*# instead of using above lines we can do it with a single line,  like this
//        Employee employeeModelMapper = modelMapper.map(dto, Employee.class);

        // convert DTO to Entity by using ModelMapper
        Employee saveEmp = employeeRepo.save(modelMapper.map(dto, Employee.class));

        // Convert Entity to DTO by using ModelMapper
//        EmployeeDto saveEmployeeDto= modelMapper.map(saveEmp , EmployeeDto.class);
        return  modelMapper.map(saveEmp , EmployeeDto.class); // saveEmployeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        // calling data from Repo ; repo gives you Entities ; catch it in to Entities
        List<Employee> employeeDtoList = employeeRepo.findAll();

        // before send it to service need to convert that Entity list to DTO
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        // for convert one by one we can use for each loop
        for (Employee employee:employeeDtoList        ) {
            // to convert,  we use model mapper
            employeeDtos.add(modelMapper.map(employee,EmployeeDto.class));
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto deleteEmployee(Integer id) {
       Employee searchEmp =  employeeRepo.findById(id).get();
       employeeRepo.delete(searchEmp);
       return modelMapper.map(searchEmp,EmployeeDto.class);

    }

     @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id) {
       Employee updateEmp =  employeeRepo.findById(id).get();

       updateEmp.setName(employeeDto.getName());
       updateEmp.setPhone(employeeDto.getPhone());

       employeeRepo.save(updateEmp);

       return  modelMapper.map(updateEmp,EmployeeDto.class);
    }
    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Employee emp = employeeRepo.findById(id).get();

        return  modelMapper.map(emp, EmployeeDto.class);
    }

}
