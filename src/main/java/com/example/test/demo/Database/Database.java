package com.example.test.demo.Database;

import com.example.test.demo.Models.Product1;
import com.example.test.demo.Repositories.Product1Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(Product1Repository productRepository){

        return  new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        }  ;
    }
}
