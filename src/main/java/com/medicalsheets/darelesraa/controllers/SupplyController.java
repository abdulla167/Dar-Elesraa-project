package com.medicalsheets.darelesraa.controllers;

import com.medicalsheets.darelesraa.entites.MedicalService;
import com.medicalsheets.darelesraa.entites.Supply;
import com.medicalsheets.darelesraa.response.ResponseHandler;
import com.medicalsheets.darelesraa.services.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupplyController {
    private final SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping("/supply")
    ResponseEntity<Object> addSupply(@RequestBody Supply supply){
        supplyService.addSupply(supply);
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Service is added successfully", HttpStatus.CREATED, supply);
        } else {
            responseEntity = ResponseHandler.generateResponse("Service is already exist", HttpStatus.CONFLICT, null);
        }
        return responseEntity;
    }

    @GetMapping("/supplies/{supplyId}")
    ResponseEntity<Object> getSupply(@PathVariable("supplyId") long medicineId){
        ResponseEntity responseEntity = null;
        Optional<Supply> theSupply = supplyService.getSupplyById(medicineId);
        if (theSupply.isPresent()){
            responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, theSupply.get());
        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @PutMapping("/supplies/{supplyId}")
    ResponseEntity<Object> modifySupply(@RequestBody Supply modifiedSupply,@PathVariable("supplyId") long supplyId){
        boolean result = supplyService.updateSupply(modifiedSupply, supplyId);
        ResponseEntity responseEntity = null;
        if (result){
            responseEntity = ResponseHandler.generateResponse("Medicine is modified successfully", HttpStatus.NO_CONTENT, null);

        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @DeleteMapping("/supplies/{supplyId}")
    ResponseEntity<Object> deleteSupply(@PathVariable("supplyId") int id){
        supplyService.deleteSupply(id);
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Medicine is deleted successfully", HttpStatus.OK, null);
        } else {
            responseEntity = ResponseHandler.generateResponse("Medicine is not found", HttpStatus.NOT_FOUND, null);
        }
        return responseEntity;
    }

    @GetMapping("/supplies")
    ResponseEntity<Object> getSupplies(){
        List<Supply> suppliesList =supplyService.getSupplies();
        ResponseEntity responseEntity = null;
        responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, suppliesList);
        return responseEntity;
    }
}
