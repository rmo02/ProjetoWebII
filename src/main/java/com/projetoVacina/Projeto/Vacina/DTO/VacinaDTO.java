package com.projetoVacina.Projeto.Vacina.DTO;

import jakarta.validation.constraints.NotBlank;

public record VacinaDTO(
        @NotBlank
        String nome,
        @NotBlank
        String data
) {
}
