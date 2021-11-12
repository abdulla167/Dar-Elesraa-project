package com.medicalsheets.darelesraa.entites;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@ToString
@Entity
@Table(name = "service")
@Setter
@Getter
public class MedicalService {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "cost")
    private int cost;

    @ToString.Exclude
    @OneToMany(mappedBy = "medicalService", cascade = CascadeType.REMOVE)
    private Set<SheetService> sheetServices;
}
