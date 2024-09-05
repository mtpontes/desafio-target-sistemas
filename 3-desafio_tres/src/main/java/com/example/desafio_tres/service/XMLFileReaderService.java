package com.example.desafio_tres.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.desafio_tres.wrapper.FaturamentoWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class XMLFileReaderService {

	private XmlMapper mapper = new XmlMapper();


	public List<FaturamentoWrapper> readFaturamentoDiarioFromXML(Path filePath) throws IOException {
		try {
			String fileContent = Files.readString(filePath);
			return mapper.readValue(fileContent, new TypeReference<List<FaturamentoWrapper>>(){});

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo!");
			throw e;
		}
	}
}