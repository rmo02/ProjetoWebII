package com.projetoVacina.Projeto.Vacina.model;

import com.projetoVacina.Projeto.Vacina.DTO.VacinaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="vacina")
@Entity

public class Vacina implements Serializable {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 250)
    private String nome;
    @Column(nullable = false, length = 250)
    private String data;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
