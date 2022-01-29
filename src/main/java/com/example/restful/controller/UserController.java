package com.example.restful.controller;

import com.example.restful.service.UserDaoService;
import com.example.restful.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 의존성 주입은 생성자, setter를 통한 주입이 가능하다.
@RestController
public class UserController {
    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    // curl -i -X GET http://localhost:8888/users
    // GET /users
    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    // curl -i -X GET http://localhost:8888/users/1
    // GET /users/1
    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        return userDaoService.findById(id);
    }
}
