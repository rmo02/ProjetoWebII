package com.projetoVacina.Projeto.Vacina.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PacienteSVacinaDTO(
        @NotBlank
        String pacienteNome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String dataNasc,
        @NotBlank
        String senha
) {
}

