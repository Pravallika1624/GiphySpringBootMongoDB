package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@ComponentScan("com.demo.*")
@EnableMongoRepositories(basePackages="com.demo.*")
@EntityScan(basePackages="com.demo.*")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class NotesMongoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesMongoCrudApplication.class, args);
	}

}
