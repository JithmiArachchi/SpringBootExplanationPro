package com.springProject.spring_boot.Controller;


// request handling

import com.springProject.spring_boot.dto.EmployeeDto;
import com.springProject.spring_boot.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        EmployeeDto employeeDto = employeeService.saveEmployee(dto);
        EmployeeDto employeeDtoModelMapperExample = employeeService.saveEmployeeModelMapper(dto);

        if (employeeDto != null) {
            // 10 ** send success msg or DTO details to front end
            return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
        }

        // 10 ** send success msg or DTO details to front end
        return new ResponseEntity<>(employeeDto, HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> loadEmployees() {
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();

        return ResponseEntity.ok(employeeDtoList);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<EmployeeDto> deleteEmployees(@PathVariable Integer id) {

        EmployeeDto employeeDto = employeeService.deleteEmployee(id);

        return ResponseEntity.ok(employeeDto);


    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> editEmployee(@RequestBody EmployeeDto employeeDto, // what
                                                    @PathVariable Integer id) {  // who

        EmployeeDto employeeDtoUpdate = employeeService.updateEmployee(employeeDto, id);
        if (employeeDtoUpdate != null) {
            return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(employeeDtoUpdate, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        EmployeeDto searchById = employeeService.getEmployeeById(id);

      return   ResponseEntity.ok(searchById);

    }
}
