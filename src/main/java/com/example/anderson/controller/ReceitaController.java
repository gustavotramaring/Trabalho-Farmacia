package com.example.anderson.controller;

import com.example.anderson.Model.Receita;
import com.example.anderson.Service.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public ResponseEntity<List<Receita>> listarReceitas() {
        List<Receita> receitas = receitaService.listarReceitas();
        return ResponseEntity.ok(receitas);
    }

    @PostMapping
    public ResponseEntity<Receita> criarReceita(@RequestBody Receita receita) {
        Receita novaReceita = receitaService.criarReceita(receita);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscarReceitaPorId(@PathVariable Long id) {
        Receita receita = receitaService.buscarReceitaPorId(id);
        return receita != null ? ResponseEntity.ok(receita) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirReceita(@PathVariable Long id) {
        receitaService.excluirReceita(id);
        return ResponseEntity.noContent().build();
    }
}
