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
    private String nomeMedicamento;
    @Column
    private int dosagem;
    @Column
    private int quantidade;
    @Column
    private String viaDeAdministracao;
    @Column
    private String observacoes;

    public Medicamento() {

    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
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

    public String getViaDeAdministracao() {
        return viaDeAdministracao;
    }

    public void setViaDeAdministracao(String viaDeAdministracao) {
        this.viaDeAdministracao = viaDeAdministracao;
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

    public Medicamento(Long id, String nomeMedicamento, int dosagem, int quantidade, String viaDeAdministracao, String observacoes) {
        this.id = id;
        this.nomeMedicamento = nomeMedicamento;
        this.dosagem = dosagem;
        this.quantidade = quantidade;
        this.viaDeAdministracao = viaDeAdministracao;
        this.observacoes = observacoes;
    }
}
