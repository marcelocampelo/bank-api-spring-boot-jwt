package br.com.bank.restapispringboot.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TransferPost implements Serializable {

    private static final long serialVersionUID = 1L;


    private String source_account_number;

    private String destination_account_number;

    private BigDecimal amount;

    public String getSource_account_number() {
        return source_account_number;
    }

    public void setSource_account_number(String source_account_number) {
        this.source_account_number = source_account_number;
    }

    public String getDestination_account_number() {
        return destination_account_number;
    }

    public void setDestination_account_number(String balanceDestination) {
        this.destination_account_number = balanceDestination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferPost that = (TransferPost) o;
        return Objects.equals(source_account_number, that.source_account_number) && Objects.equals(destination_account_number, that.destination_account_number) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source_account_number, destination_account_number, amount);
    }
}