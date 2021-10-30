package com.medicalsheets.darelesraa.Entites;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "sheet_medicine")
public class SheetMedicine {

    @EmbeddedId
    private PatientMedicinePK patientMedicinePK;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientSheetId")
    private PatientSheet patient;

    @Setter
    @Getter
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medicineId")
    private Medicine medicine;

    @Column(name = "day_num")
    private int dayNum;

    @Column(name = "quantity")
    private int quantity;

}
