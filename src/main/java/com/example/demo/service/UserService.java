package com.example.demo.service;



import com.example.demo.dto.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<com.example.demo.entity.User> getUsers(String firstName);
}
