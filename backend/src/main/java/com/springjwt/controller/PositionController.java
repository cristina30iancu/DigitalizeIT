package com.springjwt.controller;

import com.springjwt.models.Equipment;
import com.springjwt.models.Position;
import com.springjwt.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
public class PositionController {
    @GetMapping
    public List<String> getPositions() {
        return Arrays.stream(Position.values()).map(p->p.name()).collect(Collectors.toList());
    }
}
