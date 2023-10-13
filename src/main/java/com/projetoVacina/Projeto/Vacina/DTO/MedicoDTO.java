package com.projetoVacina.Projeto.Vacina.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MedicoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @NotBlank
        @Email
        String email
) {
}
