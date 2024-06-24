package com.example.anderson.controller;

import com.example.anderson.Model.Farmacia;
import com.example.anderson.Repository.FarmaciaRepository;
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

    @Autowired
    private FarmaciaService farmaciaService;
    private Farmacia authenticatedFarmacia;

    @GetMapping("/listar")
    public List<Farmacia> listarFarmacias() {
        return farmaciaService.listarFarmacias();
    }

    @PostMapping("/cadastrarFarmacia")
    public ResponseEntity<Farmacia> cadastrarFarmacia(@RequestBody Farmacia farmacia) {
        Farmacia novaFarmacia = farmaciaService.cadastrarFarmacia(farmacia);
        if (novaFarmacia == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(novaFarmacia, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Farmacia> buscarFarmaciaPorId(@PathVariable Long id) {
        Farmacia farmacia = farmaciaService.buscarFarmaciaPorId(id);
        if (farmacia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(farmacia, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirFarmacia(@PathVariable Long id) {
        farmaciaService.excluirFarmacia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Farmacia> alterarFarmacia(@PathVariable Long id, @RequestBody Farmacia farmacia) {
        Farmacia farmaciaAtualizada = farmaciaService.alterarFarmacia(id, farmacia);
        if (farmaciaAtualizada == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(farmaciaAtualizada, HttpStatus.OK);
    }

    @PostMapping(path = "/loginFarmacia")
    public ResponseEntity<Farmacia> loginFarmacia(@RequestBody Farmacia farmacia) {
        Farmacia authenticatedFarmacia = farmaciaService.autenticarFarmacia(farmacia.getCnpj(), farmacia.getSenha());
        if (authenticatedFarmacia != null) {
            return new ResponseEntity<>(authenticatedFarmacia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
