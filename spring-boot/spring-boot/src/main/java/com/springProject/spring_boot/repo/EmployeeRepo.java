package com.springProject.spring_boot.repo;


import com.springProject.spring_boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee , Integer> {
    // 05 send Entity type data to DB

    // 06 **  if save success - send response Entities to ServiceImpl

}
