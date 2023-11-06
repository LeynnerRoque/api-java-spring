package br.com.api.curso.controller;

import br.com.api.curso.model.Medico;
import br.com.api.curso.records.MedicoRecord;
import br.com.api.curso.records.dtos.MedicoListagens;
import br.com.api.curso.service.MedicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid MedicoRecord body){
        service.create(body);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<MedicoRecord> listarTodos(){
        return service.getall();
    }

    @GetMapping("/allPages")
    public List<MedicoListagens> listarFormatados(){
        return service.getallFormated();
    }

    @GetMapping("/pages")
    public Page<Medico> listarFormatados(Pageable pg){
        return service.pageMedicos(pg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity getMedicoById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody @Valid MedicoRecord body){
        return  ResponseEntity.ok(service.update(body));
    }
}
