package com.example.anderson.Service;

import com.example.anderson.Model.Medicamento;
import com.example.anderson.Repository.MedicamentoRepository;
import com.example.anderson.Service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class MedicamentoServiceConcrete implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public Medicamento cadastrarMedicamento(Medicamento medicamento) {
        if (medicamento.getNomeMedicamento() == null || medicamento.getNomeMedicamento().isEmpty()) {
            return null;
        }
        return medicamentoRepository.save(medicamento);
    }

    @Override
    public List<Medicamento> listarMedicamentos() {
        return medicamentoRepository.findAll();
    }

    @Override
    public Medicamento buscarMedicamentoPorId(Long id) {
        if (id <= 0) {
            return null;
        }
        return medicamentoRepository.findById(id).orElse(null);
    }

    @Override
    public void excluirMedicamento(Long id) {
        if (id <= 0) {
            return;
        }
        medicamentoRepository.deleteById(id);
    }

    public Medicamento alterarMedicamento(Long id, Medicamento medicamento) {
        if (id == null || id <= 0) {
            return null;
        }
        medicamento.setId(id);
        return medicamentoRepository.save(medicamento);
    }


}
