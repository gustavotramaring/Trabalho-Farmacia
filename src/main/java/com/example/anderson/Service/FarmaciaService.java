package com.example.anderson.Service;


import com.example.anderson.Model.Farmacia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FarmaciaService {

    Farmacia cadastrarFarmacia(Farmacia farmacia);

    List<Farmacia> listarFarmacias();

    Farmacia buscarFarmaciaPorId(Long id);

    void excluirFarmacia(Long id);

    Farmacia alterarFarmacia(Long id, Farmacia farmacia);

    Farmacia autenticarFarmacia(int cnpj, String senha);
}
