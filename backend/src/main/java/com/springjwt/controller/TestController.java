package com.springjwt.controller;

import com.springjwt.models.JwtUser;
import com.springjwt.repository.UserRepository;
import com.springjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;

    @GetMapping("/manager")
    public TestMessage userEndpoint() {
        return new TestMessage("Hello user!");
    }

    @GetMapping("/it_support")
    public TestMessage adminEndpoint() {
        return new TestMessage("Hello admin!");
    }

    @GetMapping("/users")
    public List<JwtUser> getAllUsers(){return userService.getAllUsers();}
}
