package com.projetoVacina.Projeto.Vacina.services;

import com.projetoVacina.Projeto.Vacina.Repositories.MedicoRepository;
import com.projetoVacina.Projeto.Vacina.model.Medico;
import com.projetoVacina.Projeto.Vacina.model.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Transactional
    public Medico salvar(Medico medico){
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedico(){
        return medicoRepository.findAll();
    }

    public Optional<Medico> findMedicoID(String id){
        return medicoRepository.findById(id);
    }

    public void deletarMedico(Medico medico){
        medicoRepository.delete(medico);
    }
}
