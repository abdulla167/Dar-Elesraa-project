package com.medicalsheets.darelesraa.controllers;

import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.entites.MedicalService;
import com.medicalsheets.darelesraa.response.ResponseHandler;
import com.medicalsheets.darelesraa.services.MedicalServiceService;
import com.medicalsheets.darelesraa.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceController {

    private final MedicalServiceService medicalServiceService;

    @Autowired
    public ServiceController(MedicalServiceService medicalServiceService) {
        this.medicalServiceService = medicalServiceService;
    }

    @PostMapping("/service")
    ResponseEntity<Object> addService(@RequestBody MedicalService medicalService){
        medicalServiceService.addService(medicalService);
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Service is added successfully", HttpStatus.CREATED, medicalService);
        } else {
            responseEntity = ResponseHandler.generateResponse("Service is already exist", HttpStatus.CONFLICT, null);
        }
        return responseEntity;
    }

    @GetMapping("/services/{serviceId}")
    ResponseEntity<Object> getService(@PathVariable("serviceId") long serviceId){
        ResponseEntity responseEntity = null;
        Optional<MedicalService> theService = medicalServiceService.getServiceById(serviceId);
        if (theService.isPresent()){
            responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, theService.get());
        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @PutMapping("/services/{serviceId}")
    ResponseEntity<Object> modifyService(@RequestBody MedicalService modifiedService,@PathVariable("serviceId") long serviceId){
        boolean result = medicalServiceService.updateService(modifiedService, serviceId);
        ResponseEntity responseEntity = null;
        if (result){
            responseEntity = ResponseHandler.generateResponse("Medicine is modified successfully", HttpStatus.NO_CONTENT, null);

        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @DeleteMapping("/services/{serviceId}")
    ResponseEntity<Object> deleteMedicine(@PathVariable("serviceId") int id){
        medicalServiceService.deleteService(id);
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Medicine is deleted successfully", HttpStatus.OK, null);
        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return responseEntity;
    }

    @GetMapping("/services")
    ResponseEntity<Object> getMedicines(){
        List<MedicalService> medicineList = medicalServiceService.getServices();
        ResponseEntity responseEntity = null;
        responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, medicineList);
        return responseEntity;
    }
}
