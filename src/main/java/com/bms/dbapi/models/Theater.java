package com.bms.dbapi.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Theaters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String address;
    private String state;
    private int pinCode;

    @ManyToOne
    private AppUser owner;
    String status;
}
