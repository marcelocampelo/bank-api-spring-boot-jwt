package br.com.bank.restapispringboot.repositories;

import br.com.bank.restapispringboot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {

}
