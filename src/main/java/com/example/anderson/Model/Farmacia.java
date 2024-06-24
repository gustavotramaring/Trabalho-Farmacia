package com.example.anderson.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "FARMACIA")
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cnpj;
    private String senha;
    private int dataEHoraDaDispensacao;
    private String medicamentosDispensados;
    private int quantidadeDispensada;
    private String farmaceuticoResponsavel;

    public Farmacia(int cnpj, String senha, int dataEHoraDaDispensacao, String medicamentosDispensados, int quantidadeDispensada, String farmaceuticoResponsavel, Long id) {
        this.cnpj = cnpj;
        this.senha = senha;
        this.dataEHoraDaDispensacao = dataEHoraDaDispensacao;
        this.medicamentosDispensados = medicamentosDispensados;
        this.quantidadeDispensada = quantidadeDispensada;
        this.farmaceuticoResponsavel = farmaceuticoResponsavel;
        this.id = id;
    }

    public Farmacia() {

    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getDataEHoraDaDispensacao() {
        return dataEHoraDaDispensacao;
    }

    public void setDataEHoraDaDispensacao(int dataEHoraDaDispensacao) {
        this.dataEHoraDaDispensacao = dataEHoraDaDispensacao;
    }

    public String getMedicamentosDispensados() {
        return medicamentosDispensados;
    }

    public void setMedicamentosDispensados(String medicamentosDispensados) {
        this.medicamentosDispensados = medicamentosDispensados;
    }

    public int getQuantidadeDispensada() {
        return quantidadeDispensada;
    }

    public void setQuantidadeDispensada(int quantidadeDispensada) {
        this.quantidadeDispensada = quantidadeDispensada;
    }

    public String getFarmaceuticoResponsavel() {
        return farmaceuticoResponsavel;
    }

    public void setFarmaceuticoResponsavel(String farmaceuticoResponsavel) {
        this.farmaceuticoResponsavel = farmaceuticoResponsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
