package com.example.desafio_cinco;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioCincoApplication {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(DesafioCincoApplication.class, args);

		System.out.println("-- Demonstração --");
		String demo = inverterString("inverter");
		System.out.println(String.format("Inserimos a entrada 'inverter' e será retornado '%s'", demo));
		
		while (true) {
			System.out.println(".........................................................");
			System.out.println("\nInsira uma entrada de texto \n");
			String input = scanner.nextLine();
			String result = inverterString(input);

			System.out.println("\nString invertida: " + result);
		}
	}

	private static String inverterString(String string) {
        char[] strings = string.toCharArray();

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = strings.length - 1; i >= 0; i--) {
			stringBuilder.append(strings[i]);
		}

		return stringBuilder.toString();
    }
}