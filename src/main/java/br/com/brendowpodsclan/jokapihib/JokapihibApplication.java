package br.com.brendowpodsclan.jokapihib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "br.com.brendowpodsclan.jokapihib.repository")
@SpringBootApplication
public class JokapihibApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokapihibApplication.class, args);
    }

}

