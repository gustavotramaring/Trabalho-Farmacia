package com.example.anderson.Repository;

import com.example.anderson.Model.Medico;
import com.example.anderson.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico findByCrm(int crm);
    List<Medico> findByPacientes(Paciente paciente);
}
