package br.com.convergencia.testejavar1;

import br.com.convergencia.testejavar1.entity.User;
import br.com.convergencia.testejavar1.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TesteJavaR1Application implements CommandLineRunner {


    final PasswordEncoder encoder;

    final UserRepository repository;

    public TesteJavaR1Application(PasswordEncoder encoder, UserRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TesteJavaR1Application.class, args);
    }

    @Override
    public void run(String... args) {
        User user = new User();

        user.setCpf("33931722805");
        user.setPass(encoder.encode("123"));
        user.setActive(true);

        repository.save(user);
    }
}
