package com.projetoVacina.Projeto.Vacina.controllers;

import com.projetoVacina.Projeto.Vacina.infra.security.TokenJWT;
import com.projetoVacina.Projeto.Vacina.infra.security.TokenService;
import com.projetoVacina.Projeto.Vacina.model.usuario.UserDTO;
import com.projetoVacina.Projeto.Vacina.model.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDTO userDTO){
        var authToken = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.senha());
        var autentication = manager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((Usuario) autentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(new TokenJWT(tokenJWT));
    }
}
