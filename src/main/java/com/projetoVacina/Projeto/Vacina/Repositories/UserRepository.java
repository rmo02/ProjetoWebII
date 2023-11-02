package com.projetoVacina.Projeto.Vacina.Repositories;

import com.projetoVacina.Projeto.Vacina.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Usuario,Long > {
    UserDetails findByLogin(String login);
}
