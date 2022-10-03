package com.springjwt.controller;

import com.springjwt.models.NewJoiner;
import com.springjwt.repository.NewJoinerRepository;
import com.springjwt.service.NewJoinerService;
import com.springjwt.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("newJoiner")
public class NewJoinerController {
    private final NewJoinerService newJoinerService;

    @GetMapping("users/all")
    public List<NewJoiner> findAll() {
        return newJoinerService.getAllNewJoiners();
    }

    @GetMapping("users/{user}")
    public NewJoiner findByName(@RequestBody @PathVariable NewJoinerForm user) {
        return newJoinerService.findAllByName(user.getFirstName(), user.getLastName());
    }

    @GetMapping("projects/{title}")
    public List<NewJoiner> findByProject(@PathVariable String title) {
        return newJoinerService.findUsersByProject(title);
    }
}
