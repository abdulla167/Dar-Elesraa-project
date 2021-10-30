package com.medicalsheets.darelesraa.Entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
public class SheetPaymentPK implements Serializable {
    @Column(name = "sheet_id")
    private long sheetId;

    @Column(name = "day_num")
    private int day_num;
}
