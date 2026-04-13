package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.model.Career;
import com.rohit.career_navigator.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public List<Career> recommend(@PathVariable Long userId){
        return recommendationService.recommendCareer(userId);
    }
}
