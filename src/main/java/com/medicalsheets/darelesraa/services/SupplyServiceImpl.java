package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.entites.Supply;
import com.medicalsheets.darelesraa.repositories.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyServiceImpl implements SupplyService{
    private final SupplyRepository supplyRepository;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    @Override
    public void addSupply(Supply supply) {
        this.supplyRepository.save(supply);
    }

    @Override
    public boolean updateSupply(Supply supply, long supplyId) {
        boolean result = this.supplyRepository.existsById(supplyId);
        if (result){
            this.supplyRepository.save(supply);
        }
        return result;
    }

    @Override
    public void deleteSupply(long supplyId) {
        this.supplyRepository.deleteById(supplyId);
    }

    @Override
    public Optional<Supply> getSupplyById(long supplyId) {
        return supplyRepository.findById(supplyId);
    }

    @Override
    public Optional<Supply> getSupplyByName(String supplyName) {
        return supplyRepository.findByName(supplyName);
    }

    @Override
    public List<Supply> getSupplies() {
        return null;
    }
}
