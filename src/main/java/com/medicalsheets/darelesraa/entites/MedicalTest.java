package com.medicalsheets.darelesraa.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medical_test")
@Getter
@Setter
@NoArgsConstructor
public class MedicalTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "cost")
    private int cost;

    @Formula("price - cost")
    private int profit;

    @OneToMany(mappedBy = "medicalTest", cascade = CascadeType.REMOVE)
    private Set<SheetTest> sheetTests;
}
