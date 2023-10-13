package com.projetoVacina.Projeto.Vacina.controllers;

import com.projetoVacina.Projeto.Vacina.DTO.MedicoDTO;
import com.projetoVacina.Projeto.Vacina.model.Medico;
import com.projetoVacina.Projeto.Vacina.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @GetMapping
    public ResponseEntity<List<Medico>> getMedico(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.listarMedico());
    }

    @PostMapping
    public ResponseEntity<Object> criarMedico(@RequestBody @Valid MedicoDTO medicoDTO){
        var medicoModel = new Medico();
        BeanUtils.copyProperties(medicoDTO, medicoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.salvar(medicoModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarMedico(@PathVariable(value = "id") String id, @RequestBody @Valid MedicoDTO medicoDTO){
        Optional<Medico>  medicoOptional = medicoService.findMedicoID(id);
        if (!medicoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não cadastrado");
        }

        var medicoModel = new Medico();
        BeanUtils.copyProperties(medicoDTO, medicoModel);
        medicoModel.setId(medicoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.salvar(medicoModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarMedicoID(@PathVariable(value = "id") String id){
        Optional<Medico>  medicoOptional = medicoService.findMedicoID(id);
        if (!medicoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não cadastrado");
        }

       return ResponseEntity.status(HttpStatus.OK).body(medicoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarMedico(@PathVariable(value = "id") String id){
        Optional<Medico> medicoOptional = medicoService.findMedicoID(id);
        if(!medicoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não localizado");
        }
        medicoService.deletarMedico(medicoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Medico excluido com sucesso!");
    }
}
