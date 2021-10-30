package com.medicalsheets.darelesraa.Entites;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String  name;

    @Column(name = "price")
    private double price;

    @Column(name = "cost")
    private double cost;

    @ToString.Exclude
    @OneToMany(mappedBy = "supply", cascade = CascadeType.REMOVE)
    private Set<SheetSupply> sheetSupplies;
}
