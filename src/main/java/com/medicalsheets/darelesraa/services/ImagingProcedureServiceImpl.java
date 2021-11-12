package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.ImagingProcedure;
import com.medicalsheets.darelesraa.repositories.ImagingProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagingProcedureServiceImpl implements ImagingProcedureService{
    private ImagingProcedureRepository imagingProcedureRepository;

    @Autowired
    public ImagingProcedureServiceImpl(ImagingProcedureRepository imagingProcedureRepository){
        this.imagingProcedureRepository = imagingProcedureRepository;
    }

    @Override
    public void addImagingProcedure(ImagingProcedure imagingProcedure) {
        this.imagingProcedureRepository.save(imagingProcedure);
    }

    @Override
    public boolean updateImagingProcedure(ImagingProcedure imagingProcedure, long procedureId) {
        boolean result = this.imagingProcedureRepository.existsById(procedureId);
        if (result){
            this.imagingProcedureRepository.save(imagingProcedure);
        }
        return result;
    }

    @Override
    public void deleteImagingProcedure(long procedureId) {
        this.imagingProcedureRepository.deleteById(procedureId);
    }

    @Override
    public Optional<ImagingProcedure> getImagingProcedureById(long procedureId) {
        return this.imagingProcedureRepository.findById(procedureId);
    }

    @Override
    public Optional<ImagingProcedure> getImagingProcedureByName(String procedureName) {
        return this.imagingProcedureRepository.findByName(procedureName);
    }

    @Override
    public List<ImagingProcedure> getImagingProcedures() {
        return this.imagingProcedureRepository.findAll();
    }
}
