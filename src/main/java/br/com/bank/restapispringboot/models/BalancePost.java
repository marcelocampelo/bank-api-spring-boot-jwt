package br.com.bank.restapispringboot.models;

import java.io.Serializable;

public class BalancePost implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account_number;


    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_number() {
        return account_number;
    }
}
