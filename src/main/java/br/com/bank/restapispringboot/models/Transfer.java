package br.com.bank.restapispringboot.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table (name="transfer")
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "source", nullable = false)
    private Long source_account_number;
    @Column(name = "destination", nullable = false)
    private Long destination_account_number;
    @Column(name = "amount", nullable = false)
    private Double amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSource_account_number() {
        return source_account_number;
    }

    public void setSource_account_number(Long source_account_number) {
        this.source_account_number = source_account_number;
    }

    public Long getDestination_account_number() {
        return destination_account_number;
    }

    public void setDestination_account_number(Long destination_account_number) {
        this.destination_account_number = destination_account_number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return Objects.equals(id, transfer.id) && Objects.equals(source_account_number, transfer.source_account_number) && Objects.equals(destination_account_number, transfer.destination_account_number) && Objects.equals(amount, transfer.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source_account_number, destination_account_number, amount);
    }
}
