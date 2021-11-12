package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.entites.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplyService {
    void addSupply(Supply supply);

    boolean updateSupply(Supply supply, long supplyId);

    void deleteSupply(long supplyId);

    Optional<Supply> getSupplyById(long supplyId);

    Optional<Supply> getSupplyByName(String supplyName);

    List<Supply> getSupplies();
}

