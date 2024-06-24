package com.example.anderson.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MEDICO")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeCompleto;
    @Column
    private int crm;
    @Column
    private String assinaturaDigital;
    @Column
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Paciente> pacientes;
    @Column
    private String usuario;
    @Column
    private String senha;
    @Column
    private String certificadoDigital;

    public Medico(String nomeCompleto, int crm, String assinaturaDigital, String usuario, String senha, String certificadoDigital, Long id) {
        this.nomeCompleto = nomeCompleto;
        this.crm = crm;
        this.assinaturaDigital = assinaturaDigital;
        this.usuario = usuario;
        this.senha = senha;
        this.certificadoDigital = certificadoDigital;
        this.id = id;

    }

    public Medico() {

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getAssinaturaDigital() {
        return assinaturaDigital;
    }

    public void setAssinaturaDigital(String assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCertificadoDigital() {
        return certificadoDigital;
    }

    public void setCertificadoDigital(String certificadoDigital) {
        this.certificadoDigital = certificadoDigital;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}


