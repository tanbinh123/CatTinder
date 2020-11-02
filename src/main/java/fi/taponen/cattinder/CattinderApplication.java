package fi.taponen.cattinder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.taponen.cattinder.domain.Breed;
import fi.taponen.cattinder.domain.BreedRepository;
import fi.taponen.cattinder.domain.Cat;
import fi.taponen.cattinder.domain.CatRepository;

@SpringBootApplication
public class CattinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CattinderApplication.class, args);
	}

}
