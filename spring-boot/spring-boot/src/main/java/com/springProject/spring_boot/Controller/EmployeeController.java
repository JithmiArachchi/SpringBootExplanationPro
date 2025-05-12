package com.springProject.spring_boot.Controller;


// request handling

import com.springProject.spring_boot.dto.EmployeeDto;
import com.springProject.spring_boot.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // for rest APIs
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping                                       // 00 - get JSON type data from front end via Request body
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto dto) {
        // 09 ** - Catch Data to DTO       // 01 start -- send data to SERVICE via DTO
        EmployeeDto employeeDto        =    employeeService.saveEmployee(dto);

        if (employeeDto != null){
            // 10 ** send success msg or DTO details to front end
            return new ResponseEntity<>(employeeDto , HttpStatus.CREATED);
        }

        // 10 ** send success msg or DTO details to front end
        return new ResponseEntity<>(employeeDto , HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public void loadEmployees() {
        System.out.println("abc");
    }

    @DeleteMapping
    public void deleteEmployees() {


    }

    @PutMapping
    public void editEmployee() {

    }

    @GetMapping("/{Id}")
    public void getEmployeeById() {

    }
}
