package br.com.proiecte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

// não permite que o Spring Boot configure banco de dados e JPA
// Inserido para testar a API
/*@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})*/
public class ProiecteBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProiecteBackApplication.class, args);
    }
}