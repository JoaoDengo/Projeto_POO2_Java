package org.example.vo;

import java.time.LocalDate;

public class RelatorioAlugueisVo {
    private String nomeCliente;
    private String placaVeiculo;
    private LocalDate dataInicio;
    private LocalDate dataDevolucao;
    private Double kmPercorrido;
    private String nomeFuncionario;

    public RelatorioAlugueisVo(String nomeCliente, String placaVeiculo, LocalDate dataInicio, LocalDate dataDevolucao, Double kmPercorrido, String nomeFuncionario) {
        this.nomeCliente = nomeCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataInicio = dataInicio;
        this.dataDevolucao = dataDevolucao;
        this.kmPercorrido = kmPercorrido;
        this.nomeFuncionario = nomeFuncionario;
    }

    @Override
    public String toString() {
        return "\n\nRelatório de Aluguéis VO:\n" +
                "Nome Cliente: " + nomeCliente + "\n" +
                "Placa Veículo: " + placaVeiculo + "\n" +
                "Data de Início: " + dataInicio + "\n" +
                "Data de Devolução: " + dataDevolucao + "\n" +
                "KM Percorrido: " + kmPercorrido + "\n" +
                "Nome Funcionário: " + nomeFuncionario;
    }

}
