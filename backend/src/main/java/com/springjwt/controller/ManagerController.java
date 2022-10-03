package com.springjwt.controller;

import com.springjwt.models.NewJoiner;
import com.springjwt.service.NewJoinerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerController {
    private final NewJoinerService newJoinerService;

    @PostMapping("/newJoiner/users/add")
    public NewJoiner saveNewJoiner(@RequestBody NewJoiner newJoiner) {
        return newJoinerService.save(newJoiner);
    }
}
