package com.springjwt.controllers;

import com.springjwt.models.NewJoiner;
import com.springjwt.service.NewJoinerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/newjoiner")
public class NewJoinerController {
    private final NewJoinerService newJoinerService;

    @PostMapping("/save")
    public NewJoiner saveNewJoiner(@RequestBody NewJoiner newJoiner) {
        return newJoinerService.saveNewJoiner(newJoiner);
    }

    @GetMapping("/get")
    public List<NewJoiner> getAllNotFinishedNewJoiners() {
        return newJoinerService.getAllNotFinishedNewJoiners();
    }

}
