package fr.cesi.poealtran.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Scan and load beans
// @ComponentScan(fr.cesi.poealtran.demospring.entities)
@SpringBootApplication
public class DemospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringApplication.class, args);
	}

}
