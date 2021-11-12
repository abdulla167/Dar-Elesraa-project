package com.medicalsheets.darelesraa.repositories;

import com.medicalsheets.darelesraa.entites.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.function.SupplierUtils;

import java.util.Optional;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
    Optional<Supply> findByName(String supplyName);
}
