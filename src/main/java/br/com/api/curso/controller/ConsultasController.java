package br.com.api.curso.controller;


import br.com.api.curso.records.ConsultasRecord;
import br.com.api.curso.records.dtos.DadosConsultaDTO;
import br.com.api.curso.service.ConsultasService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultasController {

    final ConsultasService service;

    public ConsultasController(ConsultasService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DadosConsultaDTO> agendar(@RequestBody @Valid ConsultasRecord record){
        var response = service.agendarConsulta(record);
        return ResponseEntity.ok(response);
    }

}
