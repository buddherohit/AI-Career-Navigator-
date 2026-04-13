package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.dto.LearningPathResponse;
import com.rohit.career_navigator.service.LearningPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learning-path")
public class LearningPathController {

    @Autowired
    private LearningPathService learningPathService;

    @GetMapping("/{userId}")
    public List<LearningPathResponse> getLearningPath(@PathVariable Long userId){
        return learningPathService.generateLearningPath(userId);
    }
}
