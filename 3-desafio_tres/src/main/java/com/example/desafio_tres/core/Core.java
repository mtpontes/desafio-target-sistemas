package com.example.desafio_tres.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.desafio_tres.interfaces.FileDeserializer;
import com.example.desafio_tres.service.FaturamentoService;
import com.example.desafio_tres.service.FileService;
import com.example.desafio_tres.wrapper.FaturamentoWrapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Core {

    private final FileService fileService;
    private final FaturamentoService faturamentoService;
	private final List<FileDeserializer> deserializers;
    private final Scanner scanner = new Scanner(System.in);


    public void cli() {

        Path path = Paths.get("")
			.toAbsolutePath()
			.resolve("entries");

		if (Files.exists(path) && Files.isDirectory(path)) {
			try (Stream<Path> files = Files.walk(path)) {
                // recupera o arquivo
				Path filePath = fileService.menuDeArquivos(files, scanner);
				System.out.println("Arquivo escolhido: " + filePath.toFile().getName());

                // deserializa o conteúdo do arquivo em objetos Java
				List<FaturamentoWrapper> faturamentos = this.deserializeFile(filePath);

                // executa as consultas de faturamento
                faturamentoService.menuFaturamento(faturamentos);

			} catch (IOException e) {
				System.out.println("Erro ao ler diretório: " + e.getMessage());
			}
		}
    }

    private List<FaturamentoWrapper> deserializeFile(Path filePath) throws IOException {
		return deserializers.stream()
			.filter(deserializer -> deserializer.support(filePath))
			.findFirst()
			.orElseThrow(() -> new UnsupportedOperationException("Formato de arquivo não suportado"))
			.deserialize(filePath);
	}
}