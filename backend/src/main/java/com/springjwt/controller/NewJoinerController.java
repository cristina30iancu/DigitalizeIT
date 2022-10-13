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

    // De Testat ------------------------------------------------------------------------------------------------------------------
    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public NewJoiner saveNewJoiner(@RequestBody NewJoiner newJoiner) {
        List<JwtUser> userList = userService.getAllItSupport();
        for(int i=0;i<userList.size();i++){
            emailSenderService.sendEmail(userList.get(i).getEmail(),"This is subject", "This is body");
        }
        return newJoinerService.saveNewJoiner(newJoiner);
    }
    //  -----------------------------------------------------------------------------------------------------------------------------

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
