package com.example.anderson.Service;

import com.example.anderson.Model.Medicamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MedicamentoService {

    Medicamento cadastrarMedicamento(Medicamento medicamento);

    List<Medicamento> listarMedicamentos();

    Medicamento buscarMedicamentoPorId(Long id);

    void excluirMedicamento(Long id);

    Medicamento alterarMedicamento(Long id, Medicamento medicamento);
}

