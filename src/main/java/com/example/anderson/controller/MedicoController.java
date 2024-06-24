package com.example.anderson.controller;

import com.example.anderson.Model.Medico;
import com.example.anderson.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        super();
        this.medicoService = medicoService;
    }

    @GetMapping("/listarMedicos")
    public List<Medico> listarMedicos() {
        return medicoService.listarMedicos();
    }

    @PostMapping(path = "/cadastrarMedico")
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
        return new ResponseEntity<>(medicoService.cadastrarMedico(medico), HttpStatus.OK);
    }

    @PostMapping(path = "/loginMedico")
    public ResponseEntity<Medico> loginMedico(@RequestBody Medico medico) {
        Medico authenticatedMedico = medicoService.autenticarMedico(medico.getCrm(), medico.getSenha());
        if (authenticatedMedico != null) {
            return new ResponseEntity<>(authenticatedMedico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
