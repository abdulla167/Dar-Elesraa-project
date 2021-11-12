package com.medicalsheets.darelesraa.services;

import com.medicalsheets.darelesraa.entites.MedicalService;
import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {
    private ServiceRepository serviceRepository;

    @Autowired
    public MedicalServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void addService(MedicalService medicalService) {
        this.serviceRepository.save(medicalService);
    }

    @Override
    public boolean updateService(MedicalService medicalService, long serviceId) {
        boolean result = this.serviceRepository.existsById(serviceId);
        if (result){
            this.serviceRepository.save(medicalService);
        }
        return result;
    }

    @Override
    public void deleteService(long serviceId) {
        this.serviceRepository.deleteById(serviceId);
    }

    @Override
    public Optional<MedicalService> getServiceById(long serviceId) {
        return this.serviceRepository.findById(serviceId);
    }

    @Override
    public Optional<MedicalService> getServiceByName(String serviceName) {
        return this.serviceRepository.findByName(serviceName);
    }

    @Override
    public List<MedicalService> getServices() {
        return this.serviceRepository.findAll();
    }
}
