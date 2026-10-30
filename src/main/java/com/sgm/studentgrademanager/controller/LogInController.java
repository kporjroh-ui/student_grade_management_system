package com.sgm.studentgrademanager.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

public class LogInController {
    @GetMapping("/login")
    public String loginMethod(Model model){
        HashMap<String, String> loginData = new HashMap<String, String>();

        model.addAttribute("LoginModel",loginData);

        return "login";
    }
}
