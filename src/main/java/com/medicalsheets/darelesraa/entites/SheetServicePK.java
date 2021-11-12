package com.medicalsheets.darelesraa.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
public class SheetServicePK implements Serializable {
    @Column(name = "sheet_id")
    private int sheetId;

    @Column(name = "service_id")
    private int serviceId;
}
