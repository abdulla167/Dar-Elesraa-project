package com.medicalsheets.darelesraa.entites;

import javax.persistence.*;

@Entity
@Table(name = "sheet_imaging_procedure")
public class SheetImagingProcedure {
    @EmbeddedId
    private SheetImagingProcedurePK sheetImagingProcedurePK;

    @JoinColumn
    @ManyToOne
    @MapsId("sheetId")
    private PatientSheet patient;

    @JoinColumn
    @ManyToOne
    @MapsId("imagingProcedureId")
    private ImagingProcedure imagingProcedure;

}
