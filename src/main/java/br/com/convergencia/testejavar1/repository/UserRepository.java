package br.com.convergencia.testejavar1.repository;

import br.com.convergencia.testejavar1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByCpf(String cpf);

}
