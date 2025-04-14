package com.bms.dbapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "halls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private int capacity;

    @ManyToOne
    private Theater theater;
}
