package com.example.desafio_um;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioUmApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioUmApplication.class, args);

		int INDICE = 13;
		int SOMA = 0;
		int K = 0;

		while (K < INDICE) {
			K = K + 1;
			SOMA = SOMA + K;
		}

		System.out.println("\nResultado da soma: " + SOMA);
	}
}