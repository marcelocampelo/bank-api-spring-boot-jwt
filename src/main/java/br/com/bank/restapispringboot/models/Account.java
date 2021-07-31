package br.com.bank.restapispringboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table (name="account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long number;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "owner")
    private Long owner;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Account () {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number) && Objects.equals(balance, account.balance) && Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, balance, owner);
    }
}
