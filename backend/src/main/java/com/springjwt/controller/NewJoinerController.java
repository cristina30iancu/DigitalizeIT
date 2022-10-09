package com.springjwt.controller;

import com.springjwt.models.Equipment;
import com.springjwt.models.NewJoiner;
import com.springjwt.service.EmailSenderService;
import com.springjwt.service.NewJoinerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("newJoiner")
public class NewJoinerController {
    private final NewJoinerService newJoinerService;
    private final EmailSenderService emailSenderService;

    @GetMapping("all")
    public List<NewJoiner> findAll() {
        return newJoinerService.getAllNewJoiners();
    }

    @GetMapping("getByName")
    public NewJoiner findByName(@RequestBody NewJoinerForm user) {
        return newJoinerService.findAllByName(user.getFirstName(), user.getLastName());
    }

    @GetMapping("projects/{title}")
    public List<NewJoiner> findByProject(@PathVariable String title) {
        return newJoinerService.findUsersByProject(title);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public NewJoiner saveNewJoiner(@RequestBody NewJoiner newJoiner) {
        emailSenderService.sendEmail("alexandru_zugravu@yahoo.com","This is subject", "This is body");
        return newJoinerService.saveNewJoiner(newJoiner);
    }

    @GetMapping
    public List<NewJoiner> getNewJoinerListByRole() {
        return newJoinerService.getNewJoinerListByRole();
    }

    @GetMapping("equipment/{userId}")
    public List<Equipment> equipmentForUser(@PathVariable Long userId){
        return newJoinerService.equipmentForUser(userId);
    }

    @GetMapping("startDate")
    public List<NewJoiner> getNewJoinerListByStartDate() {
        return newJoinerService.getAllNewJoinersByStartDate();
    }
}
