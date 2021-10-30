package com.medicalsheets.darelesraa.Entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SheetBillPK implements Serializable {
    @Column(name = "sheet_id")
    private long sheetId;

    @Column(name = "bill_id")
    private long billId;
}
