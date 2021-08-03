package br.com.bank.restapispringboot.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class BalanceResponse implements Serializable {

        private static final long serialVersionUID = 1L;


        private String account_number;

        private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_number() {
        return account_number;
    }
}
