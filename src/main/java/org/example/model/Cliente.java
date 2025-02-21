package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String cnh;

    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public Cliente(){

    }

    public Cliente(String cpf, String cnh, String nome, String email, String telefone, String endereco) {
        this.cpf = cpf;
        this.cnh = cnh;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
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
        final StringBuilder sb = new StringBuilder("\n\nCliente{");
        sb.append("id=").append(id);
        sb.append("\n\tcpf='").append(cpf).append('\'');
        sb.append("\n\tcnh='").append(cnh).append('\'');
        sb.append("\n\tnome='").append(nome).append('\'');
        sb.append("\n\temail='").append(email).append('\'');
        sb.append("\n\ttelefone='").append(telefone).append('\'');
        sb.append("\n\tendereco='").append(endereco).append('\'');
        sb.append('}');
        return sb.toString();
    }

}



