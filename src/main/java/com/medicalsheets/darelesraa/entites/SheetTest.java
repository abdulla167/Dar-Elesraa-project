package com.medicalsheets.darelesraa.entites;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "sheet_test")
public class SheetTest {
    @EmbeddedId
    private SheetTestPK sheetTestPK;

    @JoinColumn
    @ManyToOne
    @MapsId("sheetId")
    private PatientSheet patient;

    @JoinColumn
    @ManyToOne
    @MapsId("testId")
    private MedicalTest medicalTest;

    @Column(name = "day_num")
    private int dayNum;

    @Column(name = "quantity")
    private int quantity;
}
