package com.example.anderson.controller;

import com.example.anderson.Model.Farmacia;
import com.example.anderson.Service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/farmacias")
public class FarmaciaController {

    private final FarmaciaService farmaciaService;

    @Autowired
    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @GetMapping
    public ResponseEntity<List<Farmacia>> listarFarmacias() {
        List<Farmacia> farmacias = farmaciaService.listarFarmacias();
        return ResponseEntity.ok(farmacias);
    }

    @PostMapping
    public ResponseEntity<Farmacia> cadastrarFarmacia(@RequestBody Farmacia farmacia) {
        Farmacia novaFarmacia = farmaciaService.cadastrarFarmacia(farmacia);
        return novaFarmacia != null ?
                new ResponseEntity<>(novaFarmacia, HttpStatus.CREATED) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmacia> buscarFarmaciaPorId(@PathVariable Long id) {
        Farmacia farmacia = farmaciaService.buscarFarmaciaPorId(id);
        return farmacia != null ? ResponseEntity.ok(farmacia) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFarmacia(@PathVariable Long id) {
        farmaciaService.excluirFarmacia(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmacia> alterarFarmacia(@PathVariable Long id, @RequestBody Farmacia farmacia) {
        Farmacia farmaciaAtualizada = farmaciaService.alterarFarmacia(id, farmacia);
        return farmaciaAtualizada != null ?
                ResponseEntity.ok(farmaciaAtualizada) :
                ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Farmacia> loginFarmacia(@RequestBody Farmacia farmacia) {
        Farmacia authenticatedFarmacia = farmaciaService.autenticarFarmacia(farmacia.getCnpj(), farmacia.getSenha());
        return authenticatedFarmacia != null ?
                ResponseEntity.ok(authenticatedFarmacia) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}