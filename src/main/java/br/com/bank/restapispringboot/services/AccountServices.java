package br.com.bank.restapispringboot.services;

import br.com.bank.restapispringboot.models.Account;
import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.repositories.AccountRepository;
import br.com.bank.restapispringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServices {

    @Autowired
    AccountRepository repositoryAccount;

    public Account createAccount(Account account) {
        return repositoryAccount.save(account);
    }

    public List<Account> findAllAccounts() {
        return repositoryAccount.findAll();
    }
}
