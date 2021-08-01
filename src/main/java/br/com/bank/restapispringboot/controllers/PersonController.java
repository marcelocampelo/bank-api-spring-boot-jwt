package br.com.bank.restapispringboot.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.responses.UserCreated;
import br.com.bank.restapispringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registerNew")

public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping
    public List<Person> findAll() {
        return services.findAll();
    }

    @PostMapping

    @ResponseBody
    public UserCreated userCreated(
            @RequestBody Person person) {
                services.createUser(person);
                UserCreated user = new UserCreated();
                user.setName(person.getName());
                user.setEmail(person.getEmail());
                return user;
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.ok().build();
    }

}
