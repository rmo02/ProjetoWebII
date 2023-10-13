package com.projetoVacina.Projeto.Vacina.Repositories;

import com.projetoVacina.Projeto.Vacina.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, String> {
}
