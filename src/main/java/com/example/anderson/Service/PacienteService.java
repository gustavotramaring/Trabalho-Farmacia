package com.example.anderson.Service;

import com.example.anderson.Model.Paciente;

import java.util.List;


public interface PacienteService {
    public List<Paciente> listar();

    Paciente atualizarPaciente(Paciente paciente);
    Paciente excluirPaciente(Paciente paciente);
    Paciente buscarPacientePorId(Long id);

  //  Paciente criar(Paciente paciente);

    Paciente cadastrarPaciente(Paciente paciente);
}
