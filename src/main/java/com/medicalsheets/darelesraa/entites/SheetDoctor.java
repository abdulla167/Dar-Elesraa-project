package com.medicalsheets.darelesraa.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sheet_doctor")
public class SheetDoctor {
    @EmbeddedId
    private SheetDoctorPK sheetDoctorPK;

    @ManyToOne
    @JoinColumn
    @MapsId("sheetId")
    private  PatientSheet patient;

    @ManyToOne
    @JoinColumn
    @MapsId("doctorId")
    private Doctor doctor;
}
