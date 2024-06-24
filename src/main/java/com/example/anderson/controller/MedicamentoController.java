package com.example.anderson.controller;

import com.example.anderson.Model.Medicamento;
import com.example.anderson.Service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/listar")
    public List<Medicamento> listarMedicamentos() {
        return medicamentoService.listarMedicamentos();
    }

    @PostMapping("/cadastrarMedicamento")
    public ResponseEntity<Medicamento> cadastrarMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento novoMedicamento = medicamentoService.cadastrarMedicamento(medicamento);
        if (novoMedicamento == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(novoMedicamento, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Medicamento> buscarMedicamentoPorId(@PathVariable Long id) {
        Medicamento medicamento = medicamentoService.buscarMedicamentoPorId(id);
        if (medicamento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicamento, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirMedicamento(@PathVariable Long id) {
        medicamentoService.excluirMedicamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<Medicamento> alterarMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        Medicamento medicamentoAtualizado = medicamentoService.alterarMedicamento(id, medicamento);
        if (medicamentoAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(medicamentoAtualizado, HttpStatus.OK);
    }
}
