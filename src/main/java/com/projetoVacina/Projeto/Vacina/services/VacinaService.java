package com.projetoVacina.Projeto.Vacina.services;

import com.projetoVacina.Projeto.Vacina.Repositories.VacinaRepository;
import com.projetoVacina.Projeto.Vacina.model.Vacina;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {
    @Autowired
    private VacinaRepository vacinaRepository;

    @Transactional
    public Vacina salvar(Vacina vacina){
        return vacinaRepository.save(vacina);
    }

    public List<Vacina> listarVacina(){
        return vacinaRepository.findAll();
    }

    public Optional<Vacina> findVacinaID(String id){
        return vacinaRepository.findById(id);
    }
    @Transactional
    public void deletarVacina(Vacina vacina){
        vacinaRepository.delete(vacina);
    }
}
