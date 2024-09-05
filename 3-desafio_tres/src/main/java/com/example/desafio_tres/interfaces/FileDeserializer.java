package com.example.desafio_tres.interfaces;

import java.nio.file.Path;
import java.util.List;

import com.example.desafio_tres.wrapper.FaturamentoWrapper;

public interface FileDeserializer {

    boolean support(Path path);

    List<FaturamentoWrapper> deserialize(Path path);
}