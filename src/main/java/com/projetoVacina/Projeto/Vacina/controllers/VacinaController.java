package com.projetoVacina.Projeto.Vacina.controllers;


import com.projetoVacina.Projeto.Vacina.DTO.VacinaDTO;
import com.projetoVacina.Projeto.Vacina.model.Vacina;
import com.projetoVacina.Projeto.Vacina.services.VacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vacina")
public class VacinaController {
    @Autowired
    private VacinaService vacinaService;

    @GetMapping
    public ResponseEntity<List<Vacina>> getVacina(){
        return ResponseEntity.status(HttpStatus.OK).body(vacinaService.listarVacina());
    }

    @PostMapping
    public ResponseEntity<Object> criarVacina(@RequestBody @Valid VacinaDTO vacinaDTO){
        var vacinaModel = new Vacina();
        BeanUtils.copyProperties(vacinaDTO, vacinaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaService.salvar(vacinaModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarVacina(@PathVariable(value = "id") String id, @RequestBody @Valid VacinaDTO vacinaDTO){
        Optional<Vacina> vacinaOptional = vacinaService.findVacinaID(id);
        if (!vacinaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vacina não cadastrada");
        }
        var vacinaModel = new Vacina();
        BeanUtils.copyProperties(vacinaDTO, vacinaModel);
        vacinaModel.setId(vacinaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(vacinaService.salvar(vacinaModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarVacinaID(@PathVariable(value = "id") String id){
        Optional<Vacina> vacinaOptional = vacinaService.findVacinaID(id);
        if (!vacinaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vacina não cadastrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(vacinaOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarVacina(@PathVariable(value = "id") String id){
        Optional<Vacina> vacinaOptional = vacinaService.findVacinaID(id);
        if(!vacinaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vacina não localizada");
        }
        vacinaService.deletarVacina(vacinaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vacina excluida com sucesso!");
    }
}
