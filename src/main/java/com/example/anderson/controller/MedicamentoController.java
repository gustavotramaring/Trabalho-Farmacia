package com.example.anderson.controller;

import com.example.anderson.Model.Medicamento;
import com.example.anderson.Service.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> listarMedicamentos() {
        List<Medicamento> medicamentos = medicamentoService.listarMedicamentos();
        return ResponseEntity.ok(medicamentos);
    }

    @PostMapping
    public ResponseEntity<Medicamento> cadastrarMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento novoMedicamento = medicamentoService.cadastrarMedicamento(medicamento);
        return novoMedicamento != null ?
                new ResponseEntity<>(novoMedicamento, HttpStatus.CREATED) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> buscarMedicamentoPorId(@PathVariable Long id) {
        Medicamento medicamento = medicamentoService.buscarMedicamentoPorId(id);
        return medicamento != null ? ResponseEntity.ok(medicamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedicamento(@PathVariable Long id) {
        medicamentoService.excluirMedicamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> alterarMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        Medicamento medicamentoAtualizado = medicamentoService.alterarMedicamento(id, medicamento);
        return medicamentoAtualizado != null ?
                ResponseEntity.ok(medicamentoAtualizado) :
                ResponseEntity.badRequest().build();
    }
}
