package com.springjwt.controller;

import com.springjwt.models.Position;
import com.springjwt.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;
    @PostMapping
    public Position savePosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @GetMapping
    public List<Position> getPositionListByRole() {
        return positionService.getAll();
    }
}
