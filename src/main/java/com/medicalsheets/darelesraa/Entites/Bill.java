package com.medicalsheets.darelesraa.Entites;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
    @EmbeddedId
    private SheetBillPK sheetBillPK;

    @OneToOne
    @MapsId("sheetId")
    private PatientSheet patientSheet;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "total_cost")
    private int totalCost;

    @Column(name = "total_price_with_taxes")
    @Formula("totalPrice + (totalPrice * (taxes / 100))")
    private int totalPriceWithTaxes;

    @Column(name = "taxes")
    private float taxes;
}
