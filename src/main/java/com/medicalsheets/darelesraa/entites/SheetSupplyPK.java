package com.medicalsheets.darelesraa.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
public class SheetSupplyPK implements Serializable {
    @Column(name = "sheet_id")
    private long sheetId;

    @Column(name = "supply_id")
    private long supplyId;
}
