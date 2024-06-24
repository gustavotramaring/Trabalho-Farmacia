package com.example.anderson.Service;

import com.example.anderson.Model.Farmacia;
import com.example.anderson.Model.Medico;
import com.example.anderson.Repository.FarmaciaRepository;
import com.example.anderson.Service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaServiceConcrete implements FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @Override
    public Farmacia cadastrarFarmacia(Farmacia farmacia) {
        return farmaciaRepository.save(farmacia);
    }

    @Override
    public List<Farmacia> listarFarmacias() {
        return farmaciaRepository.findAll();
    }

    @Override
    public Farmacia buscarFarmaciaPorId(Long id) {
        if (id <= 0) {
            return null;
        }
        return farmaciaRepository.findById(id).orElse(null);
    }

    @Override
    public void excluirFarmacia(Long id) {
        if (id <= 0) {
            return;
        }
        farmaciaRepository.deleteById(id);
    }

    @Override
    public Farmacia alterarFarmacia(Long id, Farmacia farmacia) {
        if (id == null || id <= 0) {
            return null;
        }
        farmacia.setId(id);
        return farmaciaRepository.save(farmacia);
    }

    @Override
    public Farmacia autenticarFarmacia(int cnpj, String senha) {
       Farmacia farmacia = farmaciaRepository.findByCnpj(cnpj);
        if (farmacia != null && farmacia.getSenha().equals(senha)) {
            return farmacia;
        } else {
            return null;
        }
    }
}
