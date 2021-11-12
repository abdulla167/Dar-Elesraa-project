package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.Doctor;
import com.medicalsheets.darelesraa.entites.ImagingProcedure;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    void addDoctor(Doctor doctor);

    boolean updateDoctor(Doctor doctor, long doctorId);

    void deleteDoctor(long doctorId);

    Optional<Doctor> getDoctorById(long doctorId);

    public Optional<Doctor> getDoctorByName(String doctorName);

    public List<ImagingProcedure> getImagingProcedures();
}
