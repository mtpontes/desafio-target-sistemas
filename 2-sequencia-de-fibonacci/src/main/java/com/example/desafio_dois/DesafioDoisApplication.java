package com.example.desafio_dois;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioDoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDoisApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		int input = 0;
		String message = """
		\n
		--- Validador de Fibonacci ---

		* Para verificar se o número é uma sequência de Fibonacci
		insira um valor numérico. 
					
		* Para sair, insira qualquer valor não-numérico
		""";
		while (true) {
			System.out.println(message);

			try {
				input = scanner.nextInt();
				scanner.nextLine();
				
			} catch (NoSuchElementException | IllegalStateException e) {
				break;
			}

			int currentValue = 0;
			int anterior = 0;
			int anteriorAoAnterior = 1;

			while(currentValue < input) {
				currentValue = anterior + anteriorAoAnterior;

				anteriorAoAnterior = anterior;
				anterior = currentValue;
			}

			int result = currentValue;
			if (result != input) System.out.println("\n ** Não pertence a sequência de Fibonacci: " + input + " **");
			else System.out.println("\n ** Pertence a sequência de Fibonacci: " + input + " **");
		}
		scanner.close();
		System.out.println("\n! Fim do processamento !");
	}
}