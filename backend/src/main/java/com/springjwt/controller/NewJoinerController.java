package com.springjwt.controller;

import com.springjwt.models.NewJoiner;
import com.springjwt.service.NewJoinerService;
import com.springjwt.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/newJoiner")
public class NewJoinerController {
    private final NewJoinerService newJoinerService;

    @PostMapping
    public NewJoiner saveNewJoiner(@RequestBody NewJoiner newJoiner) {
        return newJoinerService.saveNewJoiner(newJoiner);
    }

    @GetMapping
    public List<NewJoiner> getNewJoinerListByRole() {
        return newJoinerService.getNewJoinerListByRole();
    }
}
