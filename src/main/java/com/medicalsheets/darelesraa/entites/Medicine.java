package com.medicalsheets.darelesraa.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "medicine")
@Getter
@Setter
@ToString
public class Medicine{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "cost")
    private double cost;

    @ToString.Exclude
    @OneToMany(mappedBy = "medicine", cascade = CascadeType.REMOVE)
    // This is used due to problem with message converter and lazy fetching
    @JsonIgnore
    private Set<SheetMedicine> sheetMedicines;
}
