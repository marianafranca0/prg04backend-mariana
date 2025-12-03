package br.com.ifba;

import org.springframework.boot.SpringApplication;

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