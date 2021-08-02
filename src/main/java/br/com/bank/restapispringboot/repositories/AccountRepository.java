package br.com.bank.restapispringboot.repositories;

import br.com.bank.restapispringboot.models.Account;
import br.com.bank.restapispringboot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository <Account, Long> {
    List<Account> findByOwner(String owner);
}
