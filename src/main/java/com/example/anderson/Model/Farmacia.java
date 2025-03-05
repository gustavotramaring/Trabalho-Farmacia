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
    private int dataDisp;
    private String medDisp;
    private int qtdDisp;
    private String responsavel;

    public Farmacia(int cnpj, String senha, int dataDisp, String medDisp, int qtdDisp, String responsavel, Long id) {
        this.cnpj = cnpj;
        this.senha = senha;
        this.dataDisp = dataDisp;
        this.medDisp = medDisp;
        this.qtdDisp = qtdDisp;
        this.responsavel = responsavel;
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

    public int getDataDisp() {
        return dataDisp;
    }

    public void setDataDisp(int dataDisp) {
        this.dataDisp = dataDisp;
    }

    public String getMedDisp() {
        return medDisp;
    }

    public void setMedDisp(String medDisp) {
        this.medDisp = medDisp;
    }

    public int getQtdDisp() {
        return qtdDisp;
    }

    public void setQtdDisp(int qtdDisp) {
        this.qtdDisp = qtdDisp;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
