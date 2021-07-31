package br.com.bank.restapispringboot.services;

import br.com.bank.restapispringboot.exceptions.ResourceNotFound;
import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServices {
    /* This counter is going to simulate the id Key of the database since we won't use one over this project */
    @Autowired
    PersonRepository repository;

    public Person createUser(Person person) {
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person update(Person person) {
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));

        entity.setName(person.getName());
        entity.setEmail(person.getEmail());
        entity.setPassword(person.getPassword());

        return repository.save(entity);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
        repository.delete(entity);
    }
}
