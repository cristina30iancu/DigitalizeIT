package com.springjwt.service;

import com.springjwt.models.Position;
import com.springjwt.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public Position addPosition(Position position){return positionRepository.save(position);}

    public List<Position> getAll() {
        return positionRepository.findAll();
    }
}
