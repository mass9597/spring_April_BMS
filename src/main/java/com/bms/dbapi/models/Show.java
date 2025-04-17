package com.bms.dbapi.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "shows")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    Long startTime;
    Long endTime;

    @ManyToOne
    Hall hall;

    @ManyToOne
    Movie movie;

}
