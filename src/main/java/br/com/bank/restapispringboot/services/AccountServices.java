package br.com.bank.restapispringboot.services;

import br.com.bank.restapispringboot.exceptions.ResourceNotFound;
import br.com.bank.restapispringboot.jwtconfig.IAuthenticationFacade;
import br.com.bank.restapispringboot.models.*;
import br.com.bank.restapispringboot.repositories.AccountRepository;
import br.com.bank.restapispringboot.repositories.TransferRepository;
import br.com.bank.restapispringboot.responses.UserCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServices {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    private IAuthenticationFacade authenticationFacade;
    @Autowired
    private PersonServices personServices;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public TransferResponse transfer(Transfer transfer, TransferPost transferPost) {
        Account sourceAccount = accountRepository.findById(transfer.getSource_account_number())
                .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));

        Authentication authentication = authenticationFacade.getAuthentication();

        if (Objects.equals(authentication.getName(), sourceAccount.getOwner())){
            Account destinationAccount = accountRepository.findById(transfer.getDestination_account_number())
                    .orElseThrow(() -> new ResourceNotFound("No records found for this ID"));

            BigDecimal sourceNewBalance = sourceAccount.getBalance().subtract(transfer.getAmount());

            BigDecimal zero = new BigDecimal(0);

            //check if balance of source won't become negative nor the transfer is a negative value
            if (sourceNewBalance.compareTo(zero) >=0 && transfer.getAmount().compareTo(zero) >=0 ) {
                sourceAccount.setBalance(sourceNewBalance);
                destinationAccount.setBalance(destinationAccount.getBalance().add(transfer.getAmount()));
                //save transfer on Repository,DB
                transferRepository.save(transfer);
            }
        }
        UserCreated userCreated = personServices.userName(authentication.getName());
        TransferResponse transferResponse = new TransferResponse(transferPost, userCreated);
        return transferResponse;
    }

    public List<Account> findAllAccounts(String owner) {
        return accountRepository.findByOwner(owner);
    }

    public BalanceResponse findBalanceById(String accountNumber) {
        Account account = findAccountById(accountNumber);
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBalance(account.getBalance());
        balanceResponse.setAccount_number(accountNumber);
        return balanceResponse;
    }

    public Account findAccountById(String accountNumber) {
        return accountRepository.findByNumber(Long.valueOf(accountNumber.replaceAll("[^0-9]","")));
    }
}
