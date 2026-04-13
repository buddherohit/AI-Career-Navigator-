package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.model.Skill;
import com.rohit.career_navigator.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    public Skill addSkill(@RequestBody Skill skill){
        return skillService.addSkill(skill);
    }

    @GetMapping
    public List<Skill> getSkills(){
        return skillService.getSkills();
    }
}
