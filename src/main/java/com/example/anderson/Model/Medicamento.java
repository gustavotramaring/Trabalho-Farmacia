package com.example.anderson.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "MEDICAMENTO")


public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String medicamento;
    @Column
    private int dosagem;
    @Column
    private int quantidade;
    @Column
    private String via;
    @Column
    private String observacoes;

    public Medicamento() {

    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Medicamento(Long id, String medicamento, int dosagem, int quantidade, String via, String observacoes) {
        this.id = id;
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.quantidade = quantidade;
        this.via = via;
        this.observacoes = observacoes;
    }
}
