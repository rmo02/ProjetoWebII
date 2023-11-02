package com.projetoVacina.Projeto.Vacina.model;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Table(name="paciente")
@Entity
@Data
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 250)
    private String pacienteNome;
    @Column(nullable = false, length = 250)
    private String senha;
    @Column(nullable = false, length = 250)
    private String email;
    @Column(nullable = false, length = 250)
    private String dataNasc;

    @OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
    private List<Vacina> vacina;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

}

