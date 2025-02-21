package org.example.model;

import jakarta.persistence.*;
import org.example.enums.CategoriaVeiculo;
import org.example.enums.StatusVeiculo;

@Entity
@Table(name = "veiculos")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    @Enumerated(EnumType.STRING)
    private CategoriaVeiculo categoria;

    public Veiculo() {

    }

    public Veiculo(String placa, String marca, String modelo, String cor, int ano, StatusVeiculo status, CategoriaVeiculo categoria) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.status = status;
        this.categoria = categoria;
    }

    public CategoriaVeiculo getCategoria() {
        return categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n\nVeiculo{");
        sb.append("id=").append(id);
        sb.append("\n\tplaca='").append(placa).append('\'');
        sb.append("\n\tmarca='").append(marca).append('\'');
        sb.append("\n\tmodelo='").append(modelo).append('\'');
        sb.append("\n\tcor='").append(cor).append('\'');
        sb.append("\n\tano=").append(ano);
        sb.append("\n\tstatus='").append(status).append('\'');
        sb.append("\n\tcategoria='").append(categoria).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

