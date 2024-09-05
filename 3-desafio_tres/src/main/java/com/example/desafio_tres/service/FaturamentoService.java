package com.example.desafio_tres.service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.desafio_tres.wrapper.FaturamentoWrapper;

@Service
public class FaturamentoService {

	public void menuFaturamento(List<FaturamentoWrapper> faturamentos) {
		Double menor = this.getMenorFaturamento(faturamentos);
		Double maior = this.getMaiorFaturamento(faturamentos);
		Long diasQueExcedem = this.calcularQuantidadeDeDiasQueExcedemAMediaMensal(faturamentos);

		String faturamentoMessage = String.format("""
			Resultados:
			- MENOR valor de faturamento em um dia do mês: %.2f
			- MAIOR valor de faturamento em um dia do mês: %.2f
			- Quantidade de dias no mês que excedem a média mensal: %d
			""",
			menor, maior, diasQueExcedem);
		
		System.out.println(faturamentoMessage);
	}

	private Double getMenorFaturamento(List<FaturamentoWrapper> faturamentos) {
		return faturamentos.stream()
			.map(faturamento -> faturamento.getValor())
			.filter(f -> f > 0.00)
			.min(Comparator.comparing(t -> t))
			.orElseThrow(() -> new NoSuchElementException("Não há elementos para calcular"));
	}

	private Double getMaiorFaturamento(List<FaturamentoWrapper> faturamentos) {
		return faturamentos.stream()
			.map(faturamento -> faturamento.getValor())
			.filter(f -> f > 0.00)
			.max(Comparator.comparing(t -> t))
			.orElseThrow(() -> new NoSuchElementException("Não há elementos para calcular"));
	}

	private Long calcularQuantidadeDeDiasQueExcedemAMediaMensal(List<FaturamentoWrapper> faturamentos) {
		Double mediaMensal = faturamentos.stream()
			.filter(faturamento -> faturamento.getValor() > 0.00)
			.map(faturamento -> faturamento.getValor())
			.reduce(0.00, Double::sum) / faturamentos.size();

		return faturamentos.stream()
			.filter(faturamento -> faturamento.getValor() > mediaMensal)
			.count();
	}
}