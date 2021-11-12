package com.medicalsheets.darelesraa.entites;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "sheet_service")
@Getter
@Setter
@ToString
public class SheetService {
    @EmbeddedId
    private SheetServicePK sheetServicePK;

    @JoinColumn
    @ManyToOne
    @MapsId("sheetId")
    private PatientSheet patient;

    @JoinColumn
    @ManyToOne
    @MapsId("serviceId")
    private MedicalService medicalService;

    @Column(name = "dayNum")
    private int dayNum;

    @Column(name = "quantity")
    private int quantity;
}
