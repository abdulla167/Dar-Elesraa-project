package com.medicalsheets.darelesraa.controllers;

import com.medicalsheets.darelesraa.entites.MedicalTest;
import com.medicalsheets.darelesraa.entites.Medicine;
import com.medicalsheets.darelesraa.response.ResponseHandler;
import com.medicalsheets.darelesraa.services.MedicalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MedicalTestController {
    private final MedicalTestService medicalTestService;

    @Autowired
    public MedicalTestController(MedicalTestService medicalTestService) {
        this.medicalTestService = medicalTestService;
    }

    @PostMapping("/medical-test")
    ResponseEntity<Object> addMedicine(@RequestBody MedicalTest medicalTest){
        this.medicalTestService.addMedicalTest(medicalTest);
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Medical test is added successfully", HttpStatus.CREATED, medicalTest);
        } else {
            responseEntity = ResponseHandler.generateResponse("Medical test is already exist", HttpStatus.CONFLICT, null);
        }
        return responseEntity;
    }

    @GetMapping("/medical-tests/{testId}")
    ResponseEntity<Object> getMedicalTest(@PathVariable("testId") long medicalTestId){
        ResponseEntity responseEntity = null;
        Optional<MedicalTest> theMedicalTest = this.medicalTestService.getMedicalTestById(medicalTestId);
        if (theMedicalTest.isPresent()){
            responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, theMedicalTest.get());
        } else {
            responseEntity = ResponseHandler.generateResponse("Medical test is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @PutMapping("/medical-tests/{testId}")
    ResponseEntity<Object> modifyMedicalTest(@RequestBody MedicalTest medicalTest,@PathVariable("testId") long medicalTestId){
        boolean result = this.medicalTestService.updateMedicalTest(medicalTest, medicalTestId);
        ResponseEntity responseEntity = null;
        if (result){
            responseEntity = ResponseHandler.generateResponse("Medical test is modified successfully", HttpStatus.NO_CONTENT, null);

        } else {
            responseEntity = ResponseHandler.generateResponse("Medical test is not found", HttpStatus.NOT_FOUND, null);
        }
        return  responseEntity;
    }

    @DeleteMapping("/medical-tests/{testId}")
    ResponseEntity<Object> deleteMedicalTest(@PathVariable("testId") int id){
        this.medicalTestService.deleteMedicalTest(id);
        ResponseEntity responseEntity = null;
        if (true){
            responseEntity = ResponseHandler.generateResponse("Medical test is deleted successfully", HttpStatus.OK, null);
        } else {
            responseEntity = ResponseHandler.generateResponse("Medical test is not found", HttpStatus.NOT_FOUND, null);
        }
        return responseEntity;
    }

    @GetMapping("/medical-tests")
    ResponseEntity<Object> getMedicalTests(){
        List<MedicalTest> medicalTestsList = this.medicalTestService.getMedicalTests();
        ResponseEntity responseEntity = null;
        responseEntity = ResponseHandler.generateResponse("", HttpStatus.OK, medicalTestsList);
        return responseEntity;
    }
}
