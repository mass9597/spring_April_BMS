package com.bms.dbapi.models;


import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Double duration;
    private boolean released;
    private int review;
    private int totalReviewVotes;
    private String language;

    @ManyToOne
    private AppUser movieOwner;

}
