package com.example.anderson.Service;

import com.example.anderson.Model.Receita;
import com.example.anderson.Repository.ReceitaRepository;
import com.example.anderson.Service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReceitaServiceConcrete implements ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Override
    public Receita criarReceita(Receita receita) {
        receita.setDataCriacao(String.valueOf(LocalDate.now()));
        return receitaRepository.save(receita);
    }

    @Override
    public List<Receita> listarReceitas() {
        return receitaRepository.findAll();
    }

    @Override
    public Receita buscarReceitaPorId(Long id) {
        return receitaRepository.findById(id).orElse(null);
    }

    @Override
    public void excluirReceita(Long id) {
        if (id <= 0) {
            return;
        }
        receitaRepository.deleteById(id);
    }

}
