package com.medicalsheets.darelesraa.entites;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated
    private DoctorTitle title;

    @ToString.Exclude
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private Set<SheetDoctor> sheetDoctors;
}
