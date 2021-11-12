package com.medicalsheets.darelesraa.entites;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "payment")
@Getter
@Setter
@ToString
public class Payment {
    @EmbeddedId
    private SheetPaymentPK sheetPaymentPK;

    @Column(name = "paid_money")
    private int paidMoney;

    @ManyToOne
    @MapsId("sheetId")
    private PatientSheet patientSheet;
}
