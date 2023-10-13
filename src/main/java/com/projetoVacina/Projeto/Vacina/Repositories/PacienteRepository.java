package com.projetoVacina.Projeto.Vacina.Repositories;

import com.projetoVacina.Projeto.Vacina.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
