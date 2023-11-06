package br.com.alura.curso.controller;

import br.com.alura.curso.records.PacienteRecord;
import br.com.alura.curso.service.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
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


    @GetMapping("/all")
    public ResponseEntity listaTodos(){
       return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid PacienteRecord record){
       var update = service.update(record);
       return ResponseEntity.ok(update);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity delete(@PathVariable Long id){
       service.delete(id);
       return ResponseEntity.ok().build();
    }


}
