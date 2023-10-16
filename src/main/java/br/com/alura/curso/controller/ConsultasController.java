package br.com.alura.curso.controller;


import br.com.alura.curso.records.ConsultasRecord;
import br.com.alura.curso.service.ConsultasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    final ConsultasService service;

    public ConsultasController(ConsultasService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid ConsultasRecord record){
        service.agendarConsulta(record);
        return ResponseEntity.ok().build();
    }

}
