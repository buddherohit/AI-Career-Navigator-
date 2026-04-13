package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.model.Job;
import com.rohit.career_navigator.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public Job addJob(@RequestBody Job job){
        return jobService.addJob(job);
    }

    @GetMapping
    public List<Job> getJobs(){
        return jobService.getJobs();
    }
}
