package tn.etudedecas.stationdeski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StationDeSkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationDeSkiApplication.class, args);
	}

}
