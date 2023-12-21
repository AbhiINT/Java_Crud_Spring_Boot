package com.rest.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.restful.model.Person;

@RestController
@RequestMapping("/person")
public class personController {
    private static List<Person> person = new ArrayList<>();

    @GetMapping
    public List<Person> getAllPerson() {

        return person;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {

        for (Person p : person) {
            if (p.getId() == id)
                return p;

        }
        return null;

    }

    @GetMapping("/name")
    public Person getPersonByName(@RequestParam String name) {

        for (Person p : person) {
            if (p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person pers) {

        for (Person p : person) {
            if (p.getId() == pers.getId()) {

                pers.setId((long) 404);
                pers.setName("Id Already Exists");
                pers.setAddress(null);
                pers.setMobileNumber(null);

                return pers;
            } else if (p.getMobileNumber().equalsIgnoreCase(pers.getMobileNumber())) {
                pers.setId((long) 404);
                pers.setName("Mobile Number Already Exists");
                pers.setAddress(null);
                pers.setMobileNumber(null);
                return pers;
            }
        }

        pers.setId(pers.getId());
        pers.setName(pers.getName());
        pers.setMobileNumber(pers.getMobileNumber());
        pers.setAddress(pers.getAddress());

        person.add(pers);

        return pers;
    }

    public void handleError() {

        System.out.println("Id Already Exist");

    }

    @PutMapping("/{id}")
    public Person updatPerson(@PathVariable Long id, @RequestBody Person updatedPerson) {

        if (id != updatedPerson.getId()) {

            updatedPerson.setId((long) 404);
            updatedPerson.setName("Id Cant`t be Changed");
            updatedPerson.setAddress(null);
            updatedPerson.setMobileNumber(null);

            return updatedPerson;
        }

        person.removeIf(person -> person.getId().equals(id));
        updatedPerson.setId(updatedPerson.getId());
        updatedPerson.setName(updatedPerson.getName());
        updatedPerson.setMobileNumber(updatedPerson.getMobileNumber());
        updatedPerson.setAddress(updatedPerson.getAddress());
        person.add(updatedPerson);

        return updatedPerson;

    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {

        int counter = 0;
        for (Person p : person) {
            if (p.getId() == id) {
                person.remove(counter);
            }
            counter++;
        }
        counter = 0;

    }

    @GetMapping("/search/{id}")
    public String searchById(@PathVariable Long id) {
        for (Person p : person) {
            if (p.getId() == id) {
                return "Data Found at index:" + String.valueOf(person.indexOf(p));
            }

        }
        return "Data Not found";
    }

}
