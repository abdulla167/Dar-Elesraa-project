package com.medicalsheets.darelesraa.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.PrivateKey;

@Entity
@Table(name = "imaging_procedure")
@Getter
@Setter
@NoArgsConstructor
public class ImagingProcedure {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "cost")
    private String cost;
}
