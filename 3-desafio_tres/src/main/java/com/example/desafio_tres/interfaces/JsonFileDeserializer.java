package com.example.desafio_tres.interfaces;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.desafio_tres.wrapper.FaturamentoWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonFileDeserializer implements FileDeserializer {

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public boolean support(Path path) {
		return path.toFile().getName().endsWith(".json");
	}

	@Override
	public List<FaturamentoWrapper> deserialize(Path filePath) throws IOException {
		try {
			String fileContent = Files.readString(filePath);
			return mapper.readValue(fileContent, new TypeReference<List<FaturamentoWrapper>>(){});

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo JSON!");
			throw e;
		}
	}
}