package br.com.alura.curso.controller;

import br.com.alura.curso.records.PacienteRecord;
import br.com.alura.curso.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    final PacienteService service;

   public PacienteController(PacienteService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody @Valid PacienteRecord record){
       service.create(record);
       return ResponseEntity.ok().build();
    }


}
