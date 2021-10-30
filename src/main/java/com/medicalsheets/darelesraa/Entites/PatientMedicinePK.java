package com.medicalsheets.darelesraa.Entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
/* Any embeddable class must implement serializable */
public class PatientMedicinePK implements Serializable {
    @Column(name = "sheetId")
    private long patientSheetId;

    @Column(name = "medicineId")
    private long medicineId;
}
