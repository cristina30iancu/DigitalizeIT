package com.springjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/manager")
    public TestMessage userEndpoint() {
        return new TestMessage("Hello user!");
    }

    @GetMapping("/it_support")
    public TestMessage adminEndpoint() {
        return new TestMessage("Hello admin!");
    }
}
