package com.medicalsheets.darelesraa.Entites;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "patient_sheet")
@Getter
@Setter
@ToString
public class PatientSheet {
    @Column(name = "sheet_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sheetId;

    @Column(name = "patient_first_name", nullable = false)
    private String patientFirstName;

    @Column(name = "patient_middle_name", nullable = false)
    private String patientMiddleName;

    @Column(name = "patient_last_name", nullable = false)
    private String patientLastName;

    @Column(name = "patient_age", nullable = false)
    private int patientAge;

    @Column(name = "patient_phone", nullable = false)
    private String patientPhone;

    @Enumerated
    private ExitStatus exitStatus;

    @OneToOne(mappedBy = "patientSheet", cascade = CascadeType.ALL)
    private Bill bill;

    @ToString.Exclude
    @OneToMany(mappedBy = "patientSheet", cascade = CascadeType.REMOVE)
    private Set<Payment> payments;

    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    private Set<SheetMedicine> sheetMedicines;

    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    private Set<SheetSupply> sheetSupplies;

    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    private Set<SheetTest> sheetTests;

    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    private Set<SheetService> sheetServices;
}
