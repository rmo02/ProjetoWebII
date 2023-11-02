package com.projetoVacina.Projeto.Vacina.Repositories;

import com.projetoVacina.Projeto.Vacina.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, String> {
}
