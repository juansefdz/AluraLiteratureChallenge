package com.juansefdz.LiterAlura;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
		com.juansefdz.LiterAlura.Main main = new com.juansefdz.LiterAlura.Main();
		main.menu();
	}

}
