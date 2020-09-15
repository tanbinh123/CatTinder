package fi.taponen.cattinder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.taponen.cattinder.domain.Cat;
import fi.taponen.cattinder.domain.CatRepository;

@SpringBootApplication
public class CattinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CattinderApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CatRepository repository) {
		return (args) -> {
			Cat cat1 = new Cat("Gizmo", "Shy but friendly", "Helsinki", true, 2019);
			Cat cat2 = new Cat("Viiru", "Loves food", "Helsinki", true, 2019);
			Cat cat3 = new Cat("Nuutti", "Alpha male", "Hyvinkää", false, 1994);
			
			repository.save(cat1);
			repository.save(cat2);
			repository.save(cat3);
		};
	}
}
