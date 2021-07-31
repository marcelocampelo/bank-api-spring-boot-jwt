package br.com.bank.restapispringboot.controllers;

import br.com.bank.restapispringboot.models.Account;
import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.services.AccountServices;
import br.com.bank.restapispringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    private AccountServices services;

    @GetMapping
    public List<Account> findAll() {
        return services.findAllAccounts();
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return services.createAccount(account);
    }

}