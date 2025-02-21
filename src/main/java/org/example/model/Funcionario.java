package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double salario;

    public Funcionario() {

    }

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n\nFuncionario{");
        sb.append("id=").append(id);
        sb.append("\n\tnome='").append(nome).append('\'');
        sb.append("\n\tsalario=").append(salario);
        sb.append('}');
        return sb.toString();
    }
}
