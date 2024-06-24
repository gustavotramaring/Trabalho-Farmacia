package com.example.anderson.Model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PACIENTE")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @Column
    private String telefone;
    @Column
    private String email;
    public Paciente(String nome, String cpf, String telefone, String email, Long id) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.id = id;
    }

    public Paciente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Medico getMedico() {return medico;}

    public void setMedico(Medico medico) {this.medico = medico;}

}
