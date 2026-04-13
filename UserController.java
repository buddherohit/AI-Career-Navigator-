package com.rohit.career_navigator.controller;

import com.rohit.career_navigator.model.User;
import com.rohit.career_navigator.dto.AuthResponse;
import com.rohit.career_navigator.security.JwtUtil;
import com.rohit.career_navigator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rohit.career_navigator.dto.UserDTO;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public User addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody User user){
        return userService.login(user.getEmail(), user.getPassword());
    }
    @PostMapping("/refresh")
    public String refresh(@RequestBody String refreshToken){
        String email = jwtUtil.extractEmail(refreshToken);
        return jwtUtil.generateToken(email);
    }

    @PostMapping("/logout")
    public String logout(){
        return "Logout Successful";
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }

    @GetMapping("/admin")
    public String adminAccess(@RequestParam String role){

        if(!role.equals("ADMIN")){
            throw new RuntimeException("Access Denied");
        }

        return "Admin Access Granted";
    }

}
