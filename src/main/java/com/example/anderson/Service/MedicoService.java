package com.example.anderson.Service;

import com.example.anderson.Model.Medico;
import com.example.anderson.Model.Paciente;

import java.util.List;

public interface MedicoService {
    Medico cadastrarMedico(Medico medico);
    Medico autenticarMedico(int crm, String senha);
    List<Medico> listarMedicos();
    Medico atualizarMedico(Medico medico);
    void removerMedico(Medico medico);
    Medico buscarMedicoPorId(Long id);
    List<Medico> buscarMedicoPorPaciente(Paciente paciente);
}
