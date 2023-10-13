package com.projetoVacina.Projeto.Vacina.model;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Table(name="medico")
@Entity

public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 250)
    private String nome;
    @Column(nullable = false, length = 250)
    private String senha;
    @Column(nullable = false, length = 250)
    private String email;


}
