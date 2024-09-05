package com.example.desafio_tres.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FaturamentoWrapper {

    private Integer dia;
    private Double valor;
}