package com.example.anderson.Repository;

import com.example.anderson.Model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
    Farmacia findByCnpj(int cnpj);
}
