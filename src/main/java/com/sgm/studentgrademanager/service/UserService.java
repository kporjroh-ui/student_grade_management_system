package com.sgm.studentgrademanager.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void createUser();
    void updateUser();
    void deleteUser();
    void getUser();
    void getUserByEmail();
    void getUserByPhoneNumber();
    void getUserByUsername();
    void getUserByRole();
    void getAllUsers();

}
