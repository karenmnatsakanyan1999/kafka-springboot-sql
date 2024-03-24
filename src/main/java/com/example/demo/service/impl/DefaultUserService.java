package com.example.demo.service.impl;

import com.example.demo.dto.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        logger.info("Saving user with id = {}", user.getUuid());
        userRepository.save(new com.example.demo.entity.User(user.getUuid(), user.getFirstName(), user.getLastName()));
    }

    @Override
    public List<com.example.demo.entity.User> getUsers(String firstName) {
        return userRepository.getByFirstNameIgnoreCaseOrderByFirstNameAscLastNameAsc(firstName);
    }
}
