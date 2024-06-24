package com.example.anderson.controller;

import com.example.anderson.Model.Receita;
import com.example.anderson.Service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/listar")
    public List<Receita> listarReceitas() {
        return receitaService.listarReceitas();
    }

    @PostMapping("/criar")
    public ResponseEntity<Receita> criarReceita(@RequestBody Receita receita) {
        Receita novaReceita = receitaService.criarReceita(receita);
        return new ResponseEntity<>(novaReceita, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Receita> buscarReceitaPorId(@PathVariable("id") Long id) {
        Receita receita = receitaService.buscarReceitaPorId(id);
        if (receita == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(receita, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirReceita(@PathVariable Long id) {
        receitaService.excluirReceita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
