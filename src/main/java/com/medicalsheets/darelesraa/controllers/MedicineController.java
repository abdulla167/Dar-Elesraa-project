package com.medicalsheets.darelesraa.controllers;

import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.response.ResponseHandler;
import com.medicalsheets.darelesraa.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MedicineController {
    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/medicine")
    ResponseEntity<Object> addMedicine(@RequestBody Medicine medicine){
        medicineService.addMedicine(medicine);
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Medicine is added successfully", HttpStatus.CREATED, medicine);
        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is already exist", HttpStatus.CONFLICT, null);
        }
        return responseEntity;
    }

    @GetMapping("/medicines/{medicineId}")
    ResponseEntity<Object> getMedicine(@PathVariable("medicineId") long medicineId){
        ResponseEntity responseEntity = null;
        Optional<Medicine> theMedicine = medicineService.getMedicineById(medicineId);
        if (theMedicine.isPresent()){
            responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, theMedicine.get());
        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @PutMapping("/medicines/{medicineId}")
    ResponseEntity<Object> modifyMedicine(@RequestBody Medicine modifiedMedicine,@PathVariable("medicineId") long medicineId){
        boolean result = medicineService.updateMedicine(modifiedMedicine, medicineId);
        ResponseEntity responseEntity = null;
        if (result){
            responseEntity = ResponseHandler.generateResponse("Medicine is modified successfully", HttpStatus.NO_CONTENT, null);

        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @DeleteMapping("/medicines/{medicineId}")
    ResponseEntity<Object> deleteMedicine(@PathVariable("medicineId") int id){
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Medicine is deleted successfully", HttpStatus.OK, null);
        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return responseEntity;
    }

    @GetMapping("/medicines")
    ResponseEntity<Object> getMedicines(){
        List<Medicine> medicineList = medicineService.getMedicines();
        ResponseEntity responseEntity = null;
        responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, medicineList);
        return responseEntity;
    }
}
