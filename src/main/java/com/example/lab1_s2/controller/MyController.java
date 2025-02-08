package com.example.lab1_s2.controller;


import com.example.lab1_s2.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, String password) {
        userService.registerUser(username, password);
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/welcome")
    public void welcome(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:5173/"); // Redirect to React app
    }




}
