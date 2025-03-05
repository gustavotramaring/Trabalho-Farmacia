package com.example.anderson.controller;

import com.example.anderson.DTOs.PacienteDTO;
import com.example.anderson.Model.Medico;
import com.example.anderson.Model.Paciente;
import com.example.anderson.Service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Medico medico = new Medico();
        medico.setId(pacienteDTO.getMedicoId());

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setMedico(medico);

        Paciente novoPaciente = pacienteService.cadastrarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }
}
