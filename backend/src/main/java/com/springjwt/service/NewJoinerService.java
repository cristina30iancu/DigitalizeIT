package com.springjwt.service;

import com.springjwt.models.NewJoiner;
import com.springjwt.repository.NewJoinerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewJoinerService {
    private final NewJoinerRepository newJoinerRepository;

    public NewJoiner save(NewJoiner newJoiner) {
        return newJoinerRepository.save(newJoiner);
    }

    public NewJoiner findAllByName(String first, String last) {
        return newJoinerRepository.findAllByFirstNameAndLastName(first, last);
    }


    public List<NewJoiner> getAllNewJoiners() {
        return newJoinerRepository.findAll();
    }

    public List<NewJoiner> getUserByFirst(String first) {
        return newJoinerRepository.findAllByFirstName(first);
    }

    public List<NewJoiner> getUserByLast(String last) {
        return newJoinerRepository.findAllByLastName(last);
    }

    public List<NewJoiner> findUsersByProject(String projectName) {
        return newJoinerRepository.findNewJoinersByProject(projectName);
    }

}
