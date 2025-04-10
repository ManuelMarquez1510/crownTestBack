package com.crownTest.crownTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crownTest.crownTest.model.People;
import com.crownTest.crownTest.repository.PeopleRepository;

@Service
public class PeopleService {

    private static Long idCounter = 1L;

    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> getPeople() {
        return peopleRepository.fetchPeople();
    }

    public People createPerson(People person) {
        person.setId(idCounter++);
        return person;
    }
}