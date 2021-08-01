package br.com.bank.restapispringboot.services;

import br.com.bank.restapispringboot.exceptions.ResourceNotFound;
import br.com.bank.restapispringboot.models.Account;
import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.models.Transfer;
import br.com.bank.restapispringboot.repositories.AccountRepository;
import br.com.bank.restapispringboot.repositories.PersonRepository;
import br.com.bank.restapispringboot.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServices {

    @Autowired
    AccountRepository repositoryAccount;
    @Autowired
    TransferRepository transferRepository;

    public Account createAccount(Account account) {
        return repositoryAccount.save(account);
    }

    public Transfer transfer(Transfer transfer) {
        Account sourceAccount = repositoryAccount.findById(transfer.getSource_account_number())
                .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));

        Account destinationAccount = repositoryAccount.findById(transfer.getDestination_account_number())
                .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));

        Double sourceNewBalance = sourceAccount.getBalance() - transfer.getAmount();

        if (sourceNewBalance >= 0) {
            sourceAccount.setBalance(sourceNewBalance);
            destinationAccount.setBalance(destinationAccount.getBalance() + transfer.getAmount());
        }

        return transferRepository.save(transfer);
    }

    public List<Account> findAllAccounts() {
        return repositoryAccount.findAll();
    }
}
