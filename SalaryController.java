package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.dto.SalaryResponse;
import com.rohit.career_navigator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/{career}")
    public SalaryResponse getSalary(@PathVariable String career){
        return salaryService.predictSalary(career);
    }
}
