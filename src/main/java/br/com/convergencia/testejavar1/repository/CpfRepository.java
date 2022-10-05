package br.com.convergencia.testejavar1.repository;

import br.com.convergencia.testejavar1.entity.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CpfRepository extends JpaRepository<Cpf, Long> {

    Optional<Cpf> findByCpf(String cpf);
}


