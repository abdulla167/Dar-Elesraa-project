package com.medicalsheets.darelesraa.Entites;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "service")
public class Service {
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
    @OneToMany(mappedBy = "service", cascade = CascadeType.REMOVE)
    private Set<SheetService> sheetServices;
}
