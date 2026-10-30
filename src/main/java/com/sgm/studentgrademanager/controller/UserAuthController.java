package com.sgm.studentgrademanager.controller;

import com.sgm.studentgrademanager.service.UserService;

public class UserAuthController {

    private UserService userService;

    public UserAuthController(UserService userService) {
        this.userService = userService;
    }
}
