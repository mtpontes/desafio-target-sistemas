package com.example.desafio_tres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio_tres.core.Core;

@SpringBootApplication
public class DesafioTresApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DesafioTresApplication.class, args);		
	}

	@Autowired
	private Core core;


	@Override
	public void run(String... args) throws Exception {
		core.cli();
	}
}