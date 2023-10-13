package com.projetoVacina.Projeto.Vacina.model;

import com.projetoVacina.Projeto.Vacina.DTO.VacinaDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vacina {
    private String vacinaNome;
    private String dataVac;
    public Vacina(VacinaDTO dados) {
        this.vacinaNome = dados.nome();
        this.dataVac = dados.dataVac();
    }
}
