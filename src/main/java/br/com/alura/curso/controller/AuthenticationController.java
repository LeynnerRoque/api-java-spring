package br.com.alura.curso.controller;

import br.com.alura.curso.model.User;
import br.com.alura.curso.records.dtos.LoginDTO;
import br.com.alura.curso.records.dtos.TokenDTO;
import br.com.alura.curso.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginDTO dto){
        var token = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = manager.authenticate(token);
        User userLogged = (User) auth.getPrincipal();
        var generateToken = tokenService.generateToken(userLogged);
        return ResponseEntity.ok(new TokenDTO(generateToken));
    }
}
