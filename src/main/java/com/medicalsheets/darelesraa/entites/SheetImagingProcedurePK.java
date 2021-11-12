package com.medicalsheets.darelesraa.entites;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Embeddable
public class SheetImagingProcedurePK implements Serializable {
    @Column(name = "sheet_id")
    private long sheetId;
    @Column(name = "imaging_procedure_id")
    private long imagingProcedureId;
}
