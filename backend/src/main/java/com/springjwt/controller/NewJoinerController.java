package com.springjwt.controller;

import com.springjwt.models.NewJoiner;
import com.springjwt.service.NewJoinerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public NewJoiner saveNewJoiner(@RequestBody NewJoiner newJoiner) {
        System.out.println(newJoiner);
        return newJoinerService.saveNewJoiner(newJoiner);
    }

    @GetMapping
    public List<NewJoiner> getNewJoinerListByRole() {
        return newJoinerService.getNewJoinerListByRole();
    }
}
