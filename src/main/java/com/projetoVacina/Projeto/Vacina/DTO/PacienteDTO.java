package com.projetoVacina.Projeto.Vacina.DTO;

import com.projetoVacina.Projeto.Vacina.model.Vacina;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PacienteDTO(
        @NotBlank
        String pacienteNome,
        @NotBlank
        @Email
        String email,
        Vacina vacina,
        @NotBlank
        String dataNasc,
        @NotBlank
        String senha
) {
}
