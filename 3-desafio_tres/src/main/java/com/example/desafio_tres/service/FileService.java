package com.example.desafio_tres.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	public Path menuDeArquivos(Stream<Path> files, Scanner scanner) {
		// coleta todos os arquivos .json e .xml do diretório
		List<Path> paths = this.getFiles(files);

		// associa os aquivos com um número sequencialmente
		Map<Integer, Path> pathMap = this.mapFiles(paths);

		// lista os arquivos encontrados
		System.out.println("\nArquivos encontrados \n");
		pathMap.entrySet()
			.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getFileName()));

		// coleta entrada do usuário
		System.out.println("\nEscolha um arquivo inserindo o número correspondente \n");
		int pathKey = scanner.nextInt();
		scanner.nextLine();

		// valida a entrada
		if (!pathMap.containsKey(pathKey)) 
			throw new IllegalArgumentException("Arquivo não existente!");

		// retorna o arquivo escolhido
		return pathMap.get(pathKey);
	}

	private List<Path> getFiles(Stream<Path> files) {
		return files
			.filter(Files::isRegularFile)
			.filter(p -> p.toString().endsWith(".json") || p.toString().endsWith(".xml"))
			.collect(Collectors.toList());
	}

	private Map<Integer, Path> mapFiles(List<Path> paths) {
        return IntStream.range(0, paths.size())
			.boxed()
			.collect(Collectors.toMap(
				streamIndex -> streamIndex + 1, 
				streamIndex -> paths.get(streamIndex)));
	}
}