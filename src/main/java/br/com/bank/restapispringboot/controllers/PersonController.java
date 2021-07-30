package br.com.bank.restapispringboot.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Person> findAllUsers() {
        return services.findAllUsers();
    }

    @RequestMapping(value="/{id}",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Person findById(@PathVariable("id") String id) {
        return services.findById(id);
    }

    @RequestMapping(method= RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Person create(@RequestBody Person person) {
        return services.create(person);
    }



}
