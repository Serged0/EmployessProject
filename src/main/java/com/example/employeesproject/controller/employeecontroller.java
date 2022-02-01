package com.example.employeesproject.controller;

import com.example.employeesproject.entity.employee;
import com.example.employeesproject.repository.employeerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class employeecontroller {
    @Autowired
    private employeerepository eRepo;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        mav.addObject("employees", eRepo.findAll());
        return mav;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee");
        employee newEmployee = new employee();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping({"/saveEmployee"})
    public String saveEmployee(@ModelAttribute employee Employee){
        eRepo.save(Employee);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId){
        ModelAndView mav = new ModelAndView("add-employee");
        employee Employee = eRepo.findById(employeeId).get();
        mav.addObject("employee",Employee);
        return mav;
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId){
        eRepo.deleteById(employeeId);
        return "redirect:/list";
    }
}
