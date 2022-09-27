package com.springjwt.service;

import com.springjwt.models.NewJoiner;
import com.springjwt.repository.NewJoinerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewJoinerService {
    private final NewJoinerRepository newJoinerRepository;
    public List<NewJoiner> getAllNewJoiners() {
        return newJoinerRepository.findAll();
    }

    public NewJoiner saveNewJoiner(NewJoiner newJoiner) {
        return newJoinerRepository.save(newJoiner);
    }

    public List<NewJoiner> getAllNotFinishedNewJoiners() {
        return newJoinerRepository.findAll().stream().filter(n -> n.getDone().booleanValue() == false).collect(Collectors.toList());
    }

}

