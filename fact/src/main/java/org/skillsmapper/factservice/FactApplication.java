package org.skillsmapper.factservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FactApplication {

	private static final Logger log = LoggerFactory.getLogger(FactApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FactApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FactRepository repository) {
		return (args) -> {
			repository.save(new Fact("Learning", "GCP"));

			// fetch all facts
			log.info("Facts found with findAll():");
			log.info("-------------------------------");
			for (Fact fact : repository.findAll()) {
				log.info(fact.toString());
			}
			log.info("");

			// fetch an individual fact by ID
			Fact fact = repository.findById(1L);
			log.info("Fact found with findById(1L):");
			log.info("--------------------------------");
			log.info(fact.toString());
			log.info("");

			// fetch facts by type
			log.info("Fact found with findByType('Learning'):");
			log.info("--------------------------------------------");
			repository.findByType("Learning").forEach(learning -> {
				log.info(learning.toString());
			});
			log.info("");
		};
	}
}
