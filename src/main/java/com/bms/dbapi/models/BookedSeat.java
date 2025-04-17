package com.bms.dbapi.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "bookedSeats")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class BookedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    UUID showId;

    int seatNo;

}
