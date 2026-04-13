package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.model.Career;
import com.rohit.career_navigator.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public List<Career> uploadResume(@RequestParam("file") MultipartFile file) throws Exception {

        String text = resumeService.extractText(file);

        return resumeService.recommendCareer(text);
    }
}
