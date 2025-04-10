package com.crownTest.crownTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crownTest.crownTest.model.People;
import com.crownTest.crownTest.service.PeopleService;

@RestController
@RequestMapping("/api")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public List<People> getPeople() {
        return peopleService.getPeople();
    }

    @PostMapping("/people")
    public People addPerson(@RequestBody People person) {
        return peopleService.createPerson(person);
    }
}