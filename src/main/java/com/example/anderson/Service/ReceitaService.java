package com.example.anderson.Service;
import com.example.anderson.Model.Receita;

import java.util.List;

public interface ReceitaService {
    Receita criarReceita(Receita receita);
    List<Receita> listarReceitas();
    Receita buscarReceitaPorId(Long id);
    void excluirReceita(Long id);
}
