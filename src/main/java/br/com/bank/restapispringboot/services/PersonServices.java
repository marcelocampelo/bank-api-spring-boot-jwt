package br.com.bank.restapispringboot.services;

import br.com.bank.restapispringboot.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    /* This counter is going to simulate the id Key of the database since we won't use one over this project */
    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person) {
        return person;
    }

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("whitemartins");
        person.setEmail("white@martins");
        person.setPassword("123456");
        return person;
    }
    public List<Person> findAllUsers() {
        List<Person> users = new ArrayList<Person>();
        for (int i =0; i < 10; i++) {
            Person person = mockPerson(i);
            users.add(person);
        }
        return users;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("whitemartins" + i);
        person.setEmail("white@martins");
        person.setPassword("123456");
        return person;
    }
}
