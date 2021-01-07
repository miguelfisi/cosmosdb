package com.miguel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.miguel.repo.IPersonaRepo;

@SpringBootApplication
public class WebfluxDemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebfluxDemoApplication.class);

	@Autowired
	private IPersonaRepo repository;

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDemoApplication.class, args);
	}

	@PostConstruct
	public void setup() {
		LOGGER.info("Clear the database");
		this.repository.deleteAll().block();
	}

	@PreDestroy
	public void cleanup() {
		LOGGER.info("Cleaning up users");
		this.repository.deleteAll().block();
	}

}
