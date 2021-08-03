package br.com.bank.restapispringboot.models;

import br.com.bank.restapispringboot.responses.UserCreated;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;

    private BigDecimal balance;

    private UserCreated user;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserCreated getUser() {
        return user;
    }

    public void setUser(UserCreated user) {
        this.user = user;
    }
}
