package com.example.cosmosdb;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

import io.reactivex.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class CosmosdbApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(CosmosdbApplication.class);

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CosmosdbApplication.class, args);
	}

	public void run(String... var1) throws Exception {
//		final User testUser = new User("1", "Tasha", "Calderon", "4567 Main St Buffalo NY 98052");

		final User testUser2 = new User("2", "Jose", "Claros", "calle norte La Libertad");

		final User testUser3 = new User("3", "Jose", "Carbajal", "Carabayllo 135 Chaperito");

		final User testUser4 = new User("4", "Julio", "Montalvo", "San Juan de Miraflores 579");

		LOGGER.info("Saving user2: {}", testUser2);
		LOGGER.info("Saving user3: {}", testUser3);
		LOGGER.info("Saving user4: {}", testUser4);

//		 Save the User class to Azure CosmosDB database.
		final Mono<User> saveUserMono2 = repository.save(testUser2);
		final Mono<User> saveUserMono3 = repository.save(testUser3);
		final Mono<User> saveUserMono4 = repository.save(testUser4);

		final User savedUser2 = saveUserMono2.block();
		Assert.state(savedUser2 != null, "Saved user2 must not be null");
		Assert.state(savedUser2.getFirstName().equals(testUser2.getFirstName()),
				"Saved user2 first name doesn't match");
		LOGGER.info("Saved user2");

		final User savedUser3 = saveUserMono3.block();
		Assert.state(savedUser3 != null, "Saved user3 must not be null");
		Assert.state(savedUser3.getFirstName().equals(testUser3.getFirstName()),
				"Saved user3 first name doesn't match");
		LOGGER.info("Saved user3");

		final User savedUser4 = saveUserMono4.block();
		Assert.state(savedUser4 != null, "Saved user2 must not be null");
		Assert.state(savedUser4.getFirstName().equals(testUser4.getFirstName()),
				"Saved user4 first name doesn't match");
		LOGGER.info("Saved user4");

		// GET- FLUX
		// [Flux (project reactor) -> Single (JavaRx 2)]
		//[singleListUsrByName]
		final Flux<User> firstNameUserFlux = repository.findByFirstName("Jose");
		final List<User> listUsrByName = firstNameUserFlux.collectList().block();
		Single<List<User>> singleListUsrByName = Single.just(listUsrByName);
		Assert.state(singleListUsrByName != null, "singleListUsrByName must not be null");
		singleListUsrByName.subscribe(System.out::println);
		LOGGER.info("Found user by Name");
		
		//[singleListAllUsuario]
		final Flux<User> allUserFlux  = repository.findAll();
		final List<User> listAllUsr = allUserFlux.collectList().block();
		Single<List<User>> singleListAllUsuario= Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(listAllUsr);
		});
		Assert.state(singleListAllUsuario != null, "singleListAllUsuario must not be null");
		singleListAllUsuario.subscribe(System.out::println);
		LOGGER.info("Found all users ");
		
		
	

		
		
		
		
		// Nothing happens until we subscribe to these Monos.
		// findById will not return the user as user is not present.
//		final Mono<User> findByIdMono2 = repository.findById(testUser2.getId());
//		final User findByIdUser2 = findByIdMono2.block();
//		Assert.isNull(findByIdUser2, "User must be null");

//		final User savedUser2 = saveUserMono2.block();
//		final User savedUser3 = saveUserMono3.block();
//		final User savedUser4 = saveUserMono4.block();
//		Assert.state(savedUser2 != null, "Saved user2 must not be null");
//		Assert.state(savedUser3 != null, "Saved user3 must not be null");
//		Assert.state(savedUser4 != null, "Saved user4 must not be null");

//		Assert.state(savedUser2.getFirstName().equals(testUser2.getFirstName()),
//				"Saved user2 first name doesn't match");
//		LOGGER.info("Saved user2");
//		Assert.state(savedUser3.getFirstName().equals(testUser3.getFirstName()),
//				"Saved user3 first name doesn't match");
//		LOGGER.info("Saved user3");
//		Assert.state(savedUser4.getFirstName().equals(testUser4.getFirstName()),
//				"Saved user4 first name doesn't match");
//		LOGGER.info("Saved user4");

		// ####
//		final List<User> savedUserFlux = firstNameUserFlux.collectList().block();
//		Assert.state(savedUserFlux != null, "savedUserFlux must not be null");
//		LOGGER.info("Found users by findByFirstname : {}", savedUserFlux.toString());

//		final Optional<User> optionalUserResult2 = repository.findById(testUser2.getId()).blockOptional();
//		Assert.isTrue(optionalUserResult2.isPresent(), "Cannot find user2.");
//
//		final User result2 = optionalUserResult2.get();
//		Assert.state(result2.getFirstName().equals(testUser2.getFirstName()), "query result2 firstName doesn't match!");
//		LOGGER.info("Found user2 by findById : {}", result2);

//		final Optional<User> optionalUserResult3 = repository.findById(testUser3.getId()).blockOptional();
//		Assert.isTrue(optionalUserResult3.isPresent(), "Cannot find user3.");
//
//		final User result3 = optionalUserResult3.get();
//		Assert.state(result3.getLastName().equals(testUser3.getLastName()), "query result3 lastName doesn't match!");
//		LOGGER.info("Found user3 by findById : {}", result3);

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