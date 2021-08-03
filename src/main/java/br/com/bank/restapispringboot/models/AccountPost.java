package br.com.bank.restapispringboot.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountPost implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;

    private BigDecimal balance;

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


}
