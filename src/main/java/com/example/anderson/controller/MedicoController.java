package com.example.anderson.controller;

import com.example.anderson.Model.Medico;
import com.example.anderson.Service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarMedicos() {
        List<Medico> medicos = medicoService.listarMedicos();
        return ResponseEntity.ok(medicos);
    }

    @PostMapping
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
        Medico novoMedico = medicoService.cadastrarMedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @PostMapping("/login")
    public ResponseEntity<Medico> loginMedico(@RequestBody Medico medico) {
        Medico authenticatedMedico = medicoService.autenticarMedico(medico.getCrm(), medico.getSenha());
        return authenticatedMedico != null ?
                ResponseEntity.ok(authenticatedMedico) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
