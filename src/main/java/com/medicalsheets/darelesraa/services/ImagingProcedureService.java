package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.ImagingProcedure;
import com.medicalsheets.darelesraa.entites.MedicalService;

import java.util.List;
import java.util.Optional;

public interface ImagingProcedureService {
    void addImagingProcedure(ImagingProcedure imagingProcedure);

    boolean updateImagingProcedure(ImagingProcedure imagingProcedure, long procedureId);

    void deleteImagingProcedure(long procedureId);

    Optional<ImagingProcedure> getImagingProcedureById(long procedureId);

    public Optional<ImagingProcedure> getImagingProcedureByName(String procedureName);

    public List<ImagingProcedure> getImagingProcedures();
}
