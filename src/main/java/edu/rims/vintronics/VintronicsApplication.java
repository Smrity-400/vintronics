package edu.rims.vintronics;

import java.io.File;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VintronicsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VintronicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		File file = new File("uploads");
		if(!file.exists()){
			file.mkdir();
		}
	}
}	