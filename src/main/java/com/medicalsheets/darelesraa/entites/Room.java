package com.medicalsheets.darelesraa.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room_num")
    private int roomNum;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "price")
    private float price;

    @OneToOne(mappedBy = "room")
    private PatientSheet patientSheet;
}
