package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    private long id;
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "client_id",referencedColumnName = "id",nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "from_planet_id",referencedColumnName = "id",nullable = false)
    private Planet fromPlanetId;
    @ManyToOne
    @JoinColumn(name = "to_planet_id",referencedColumnName = "id",nullable = false)
    private Planet toPlanetId;
}
