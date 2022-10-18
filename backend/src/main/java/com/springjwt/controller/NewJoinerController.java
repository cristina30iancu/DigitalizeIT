package com.springjwt.controller;

import com.springjwt.models.Equipment;
import com.springjwt.models.JwtUser;
import com.springjwt.models.NewJoiner;
import com.springjwt.service.EmailSenderService;
import com.springjwt.service.NewJoinerService;
import com.springjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("newJoiner")
public class NewJoinerController {
    private final NewJoinerService newJoinerService;
    private final EmailSenderService emailSenderService;
    private final UserService userService;

    @GetMapping("all")
    public List<NewJoiner> findAll() {
        return newJoinerService.getAllNewJoiners();
    }
    @DeleteMapping("all")
    public void deleteAll() {
        newJoinerService.deleteAll();
    }
    @GetMapping("/{id}")
    public NewJoiner findById(@PathVariable Long id) {
        return newJoinerService.getById(id);
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
        return newJoinerService.saveNewJoiner(newJoiner);
    }

    @GetMapping("/done/{done}")
    public List<NewJoiner> getNewJoinerListByRole(@PathVariable Boolean done) {
        return newJoinerService.getNewJoinerListByRole(done);
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
