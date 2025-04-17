package com.bms.dbapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bills")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID billId;

    @ManyToOne
    AppUser user;

    @ManyToOne
    Show show;

    int totalAmount;
    String seats; // 1-2-3-4
    LocalDateTime startTime;
    LocalDateTime endTime;
    int totalTickets;
    String status;
}
