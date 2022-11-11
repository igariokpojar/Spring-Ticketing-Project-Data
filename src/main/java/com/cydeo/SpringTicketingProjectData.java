package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // this includes @Configuration
public class SpringTicketingProjectData {

    public static void main(String[] args) {
        SpringApplication.run(SpringTicketingProjectData.class, args);
    }




    // I am trying to add bean in the container through @Bean annotation
    // Create a class annotated with @Component
    // Write a method which return the object that you're trying to add ij the container
    // Annotate this method with @Bean
    @Bean
    public ModelMapper mapper(){ // this is not our class that's why we put it here
        return new ModelMapper();

    }
}




