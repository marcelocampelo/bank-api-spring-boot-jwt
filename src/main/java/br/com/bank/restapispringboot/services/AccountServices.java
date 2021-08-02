package br.com.bank.restapispringboot.services;

import br.com.bank.restapispringboot.exceptions.ResourceNotFound;
import br.com.bank.restapispringboot.jwtconfig.IAuthenticationFacade;
import br.com.bank.restapispringboot.models.Account;
import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.models.Transfer;
import br.com.bank.restapispringboot.repositories.AccountRepository;
import br.com.bank.restapispringboot.repositories.PersonRepository;
import br.com.bank.restapispringboot.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServices {

    @Autowired
    AccountRepository repositoryAccount;
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    public Account createAccount(Account account) {
        return repositoryAccount.save(account);
    }

    public Transfer transfer(Transfer transfer) {
        Account sourceAccount = repositoryAccount.findById(transfer.getSource_account_number())
                .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));

        Authentication authentication = authenticationFacade.getAuthentication();

        if (Objects.equals(authentication.getName(), sourceAccount.getOwner())){
            Account destinationAccount = repositoryAccount.findById(transfer.getDestination_account_number())
                    .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));

            BigDecimal sourceNewBalance = sourceAccount.getBalance().subtract(transfer.getAmount());

            BigDecimal zero = new BigDecimal(0);

            if (sourceNewBalance.compareTo(zero) >=0) {
                sourceAccount.setBalance(sourceNewBalance);
                destinationAccount.setBalance(destinationAccount.getBalance().add(transfer.getAmount()));
            }
        }

        return transferRepository.save(transfer);
    }

    public List<Account> findAllAccounts(String owner) {
        return repositoryAccount.findByOwner(owner);
    }
}
