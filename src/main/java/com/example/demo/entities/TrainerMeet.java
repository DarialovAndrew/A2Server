package com.example.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public final class TrainerMeet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Trainer trainer;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client;
    private Date date;

    public TrainerMeet(Trainer trainer, Client client, Date date) {
        this.trainer = trainer;
        this.client = client;
        this.date = date;
    }

    public TrainerMeet() {
    }

    public UUID getId() {
        return id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return "Meeting : " + this.trainer.getName() + " with " + this.client.getName() + "Date: " + this.date + "\n";
    }
}
