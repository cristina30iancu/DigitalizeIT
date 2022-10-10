package com.springjwt.controller;

import com.springjwt.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/updateemail/{userId}")
    public void updateEmail(@PathVariable("userId") Long id, @RequestBody @Email String newEmail){
        userService.updateEmail(id, newEmail);
    }
}
