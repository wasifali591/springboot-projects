package com.wasifali.amigoscode.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student wasif= new Student(
                    "wasif",
                    "wasif@mail.com",
                    LocalDate.of(1994,06,14)
            );

            Student subhankar= new Student(
                    "subhankar",
                    "subhankar@mail.com",
                    LocalDate.of(1994,02,13)
            );
            repository.saveAll(
                    List.of(wasif,subhankar)
            );
        };
    }
}