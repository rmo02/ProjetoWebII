package com.projetoVacina.Projeto.Vacina.controllers;

import com.projetoVacina.Projeto.Vacina.DTO.PacienteDTO;
import com.projetoVacina.Projeto.Vacina.DTO.PacienteSVacinaDTO;
import com.projetoVacina.Projeto.Vacina.model.Paciente;
import com.projetoVacina.Projeto.Vacina.services.PacienteService;
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
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    @GetMapping
    public ResponseEntity<List<Paciente>> getPaciente(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarPaciente());
    }

    @PostMapping
    public ResponseEntity<Object> criarPaciente(@RequestBody @Valid PacienteSVacinaDTO pacienteSVacinaDTO){
        var pacienteModel = new Paciente();
        BeanUtils.copyProperties(pacienteSVacinaDTO, pacienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.salvar(pacienteModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPaciente(@PathVariable(value = "id") String id, @RequestBody @Valid PacienteDTO pacienteDTO){
        Optional<Paciente>  pacienteOptional = pacienteService.findPacinteID(id);
        if (!pacienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não cadastrado");
        }
        var pacienteModel = new Paciente();
        BeanUtils.copyProperties(pacienteDTO, pacienteModel);
        pacienteModel.setId(pacienteOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.salvar(pacienteModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarPacienteID(@PathVariable(value = "id") String id){
        Optional<Paciente> pacienteOptional = pacienteService.findPacinteID(id);
        if (!pacienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não cadastrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pacienteOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPaciente(@PathVariable(value = "id") String id){
        Optional<Paciente> pacienteOptional = pacienteService.findPacinteID(id);
        if(!pacienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não localizado");
        }
        pacienteService.deletarPaciente(pacienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente excluido com sucesso!");
    }
}
