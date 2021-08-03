package br.com.bank.restapispringboot.models;

import br.com.bank.restapispringboot.responses.UserCreated;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransferResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String source_account_number;

    private final String destination_account_number;

    private final BigDecimal amount;

    private final UserCreated user_transfer;


    public TransferResponse(TransferPost transferPost, UserCreated userCreated) {

        this.user_transfer = userCreated;
        this.amount = transferPost.getAmount();
        this.destination_account_number = transferPost.getDestination_account_number();
        this.source_account_number = transferPost.getSource_account_number();



    }

    public String getSource_account_number() {
        return this.source_account_number;
    }

    public String getDestination_account_number() {
        return this.destination_account_number;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public UserCreated getUser_transfer() {
        return this.user_transfer;
    }
}
