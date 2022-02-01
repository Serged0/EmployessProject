package com.example.employeesproject.repository;

import com.example.employeesproject.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

public interface employeerepository extends JpaRepository<employee, Long> {


}
