package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.dto.SkillGapResponse;
import com.rohit.career_navigator.service.SkillGapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill-gap")
public class SkillGapController {

    @Autowired
    private SkillGapService skillGapService;

    @GetMapping("/{userId}")
    public List<SkillGapResponse> getSkillGap(@PathVariable Long userId){
        return skillGapService.analyzeSkillGap(userId);
    }
}
