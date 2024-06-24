package com.example.anderson.Service;


import com.example.anderson.Model.Medico;
import com.example.anderson.Model.Paciente;
import com.example.anderson.Repository.MedicoRepository;
import com.example.anderson.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceConcrete implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listar() {

        return pacienteRepository.findAll();
    }

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Paciente cadastrarPaciente(Paciente paciente) {
        Medico medico = medicoRepository.findById(paciente.getMedico().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com o ID: " + paciente.getMedico().getId()));
        paciente.setMedico(medico);
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente excluirPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscarPacientePorId(Long id) {
        return null;
    }
}
