package com.springjwt.controller;

import com.springjwt.models.ERole;
import com.springjwt.models.JwtUser;
import com.springjwt.repository.UserRepository;
import com.springjwt.service.EmailSenderService;
import com.springjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;

    @GetMapping("/manager") // toate endpoint urile care sunt specifice unui manager o sa aiba "/manager" la inceput
    public TestMessage userEndpoint() {
        return new TestMessage("Hello manager!");
    }

    @GetMapping("/it_support") // toate endpoint urile care sunt specifice unui manager o sa aiba "/it_support" la inceput
    public TestMessage adminEndpoint() {
        return new TestMessage("Hello it_support!");
    }

    @GetMapping("/users")
    public List<JwtUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long id){
       userService.deleteUserById(id);
    }

}
