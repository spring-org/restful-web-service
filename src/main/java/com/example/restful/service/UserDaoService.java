package com.example.restful.service;

import com.example.restful.exception.DuplicateUserIdException;
import com.example.restful.exception.NotFoundUserException;
import com.example.restful.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "user1", new Date()));
        users.add(new User(2, "user2", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(users.contains(user)) {
            throw new DuplicateUserIdException("이미 존재하는 Id 입니다.");
        }
        users.add(user);
        return user;
    }

    public User findById(int id) {
        return users.stream()
                .filter(user -> user.match(id))
                .findAny()
                .orElseThrow(() -> new NotFoundUserException("존재하지 않는 사용자 입니다."));
    }
}