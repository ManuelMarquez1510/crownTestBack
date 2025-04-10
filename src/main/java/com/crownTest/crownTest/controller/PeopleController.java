package com.crownTest.crownTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crownTest.crownTest.model.People;
import com.crownTest.crownTest.service.PeopleService;

@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/api/people")
    public List<People> getPeople() {
        return peopleService.getPeople();
    }
}