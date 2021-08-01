package br.com.bank.restapispringboot.repositories;
import br.com.bank.restapispringboot.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository <Transfer, Long> {

}
