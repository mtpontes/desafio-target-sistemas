package com.example.desafio_quatro;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioQuatroSanApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioQuatroSanApplication.class, args);	
		
		Map<String, Double> faturamentos = Map.of(
			"SP", 67836.43,
			"RJ", 36678.66,
			"MG", 29229.66,
			"ES", 27165.48,
			"Outros", 19849.53);
		
		Double total = faturamentos.entrySet().stream()
			.mapToDouble(entry -> entry.getValue())
			.sum();

		String representacoes = faturamentos.entrySet().stream()
			.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
			.map(faturamento -> {
				String uf = faturamento.getKey();
				double percentual = (faturamento.getValue() / total) * 100;
				return String.format("%s: %.2f%%\n", uf, percentual);
			})
			.collect(Collectors.joining());
		
		System.out.println("\nPercentual de representação de cada estado: \n");
		System.out.println(representacoes);
	}
}