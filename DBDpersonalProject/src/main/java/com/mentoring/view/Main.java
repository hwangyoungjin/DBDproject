package com.mentoring.view;

import com.mentoring.model.User;
import com.mentoring.repository.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User user = new User();

        // Create User Table
        userRepository.createTable();

        // User tuple 1 insert
        user.setId("123");
        user.setPw("123");
        user.setName("hwang1");
        user.setGender("male");
        user.setJob("student");
        userRepository.createUser(user);
        // User tuple 1 insert
        user.setId("1234");
        user.setPw("1234");
        user.setName("hwang2");
        user.setGender("male");
        user.setJob("student");
        userRepository.createUser(user);

        //name이 hwang1인 user검색
        user = userRepository.getUser("hwang1");
        System.out.println(user);
        //name이 hwang2인 user검색
        user = userRepository.getUser("hwang2");
        System.out.println(user);
    }
}
