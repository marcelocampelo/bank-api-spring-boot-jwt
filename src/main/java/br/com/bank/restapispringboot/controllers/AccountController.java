package br.com.bank.restapispringboot.controllers;

import br.com.bank.restapispringboot.jwtconfig.IAuthenticationFacade;
import br.com.bank.restapispringboot.models.*;
import br.com.bank.restapispringboot.services.AccountServices;
import br.com.bank.restapispringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    private AccountServices services;

    @Autowired
    private PersonServices personServices;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    //GET will return every account owned by the user that is logged according to Bearer Token
    @GetMapping
    public List<Account> findAll(Principal principal) {
        String emailLogged = principal.getName();
        return services.findAllAccounts(principal.getName());
    }

    @PostMapping

    public AccountResponse create(@RequestBody AccountPost newAccount) {

        Account account = new Account();
        account.setNumber(newAccount.getNumber());
        Authentication authentication = authenticationFacade.getAuthentication();
        account.setOwner(authentication.getName());
        account.setBalance(newAccount.getBalance());
        services.createAccount(account);

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setNumber(newAccount.getNumber());
        accountResponse.setUser(personServices.userName(account.getOwner()));
        accountResponse.setBalance(newAccount.getBalance());

        return accountResponse;
    }

    @PostMapping("/transfer")
    public Transfer create(@RequestBody Transfer transfer) {
        return services.transfer(transfer);
    }
}