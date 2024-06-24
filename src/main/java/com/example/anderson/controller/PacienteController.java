package com.example.anderson.controller;


import com.example.anderson.DTOs.PacienteDTO;
import com.example.anderson.Model.Medico;
import com.example.anderson.Model.Paciente;
import com.example.anderson.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController  {

    @Autowired
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        super();
        this.pacienteService = pacienteService;
    }

    @PostMapping(path = "/cadastrarP")
    public Paciente cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Medico medico = new Medico();
        medico.setId(pacienteDTO.getMedicoId());

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setMedico(medico);

        return pacienteService.cadastrarPaciente(paciente);
    }
}
