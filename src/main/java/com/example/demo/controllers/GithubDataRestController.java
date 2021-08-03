package com.example.demo.controllers;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GithubDataRestController {
    @Autowired
    private UserService userService;
    /**
     * Gets users demands on API with
     * @param login - GitHub user login
     * @return - Final users data
     */
    @GetMapping("/users/{login}")
    public ResponseEntity<User> loadData(@PathVariable("login") String login){
        User userData = userService.getUserData(login);
        if (userData== null){
            throw new UserNotFoundException("User dosent exist on GitHub");
        }
        return new ResponseEntity<>(userData,HttpStatus.OK);
    }
}
