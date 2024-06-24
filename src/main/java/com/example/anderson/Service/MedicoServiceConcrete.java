package com.example.anderson.Service;

import com.example.anderson.Model.Medico;
import com.example.anderson.Model.Paciente;
import com.example.anderson.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceConcrete implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Medico cadastrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico autenticarMedico(int crm, String senha) {
        Medico medico = medicoRepository.findByCrm(crm);
        if (medico != null && medico.getSenha().equals(senha)) {
            return medico;
        } else {
            return null;
        }
    }

    @Override
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico atualizarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void removerMedico(Medico medico) {
        medicoRepository.delete(medico);
    }

    @Override
    public Medico buscarMedicoPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medico> buscarMedicoPorPaciente(Paciente paciente) {
        return medicoRepository.findByPacientes(paciente);
    }
}
