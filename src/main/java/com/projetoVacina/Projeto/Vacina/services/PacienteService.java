package com.projetoVacina.Projeto.Vacina.services;

import com.projetoVacina.Projeto.Vacina.Repositories.PacienteRepository;
import com.projetoVacina.Projeto.Vacina.model.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente salvar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPaciente(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findPacinteID(String id){
        return pacienteRepository.findById(id);
    }
    @Transactional
    public void deletarPaciente(Paciente paciente){
        pacienteRepository.delete(paciente);
    }
}
