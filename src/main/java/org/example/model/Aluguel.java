package org.example.model;

import jakarta.persistence.*;
import org.example.enums.StatusAluguel;

import java.time.LocalDate;

@Entity
@Table(name = "alugueis")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double kmInicial;
    private double kmFinal;
    private double valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusAluguel statusAluguel;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Veiculo veiculo;

    public Aluguel() {
    }

    public Aluguel( LocalDate dataInicio, LocalDate dataFim, double kmInicial, double kmFinal, double valorTotal, StatusAluguel statusAluguel, Cliente cliente, Funcionario funcionario, Veiculo veiculo) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.valorTotal = valorTotal;
        this.statusAluguel = statusAluguel;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n\nAluguel{");
        sb.append("id=").append(id);
        sb.append("\ndataInicio=").append(dataInicio);
        sb.append("\ndataFim=").append(dataFim);
        sb.append("\nkmInicial=").append(kmInicial);
        sb.append("\nkmFinal=").append(kmFinal);
        sb.append("\nvalorTotal=").append(valorTotal);
        sb.append("\nstatusAluguel=").append(statusAluguel);
        sb.append("\ncliente=").append(cliente);
        sb.append("\nfuncionario=").append(funcionario);
        sb.append("\nveiculo=").append(veiculo);
        sb.append('}');
        return sb.toString();
    }

}
