package com.medicalsheets.darelesraa.entites;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sheet_supply")
public class SheetSupply {
    @EmbeddedId
    private SheetSupplyPK sheetSupplyPK;

    @JoinColumn
    @ManyToOne
    @MapsId("sheetId")
    private PatientSheet patient;

    @JoinColumn
    @ManyToOne
    @MapsId("supplyId")
    private Supply supply;

    @Column(name = "day_num")
    private int dayNum;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "place")
    private String placeName;
}
