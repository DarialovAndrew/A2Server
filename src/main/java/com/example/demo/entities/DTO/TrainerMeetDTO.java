package com.example.demo.entities.DTO;

import com.example.demo.entities.Client;
import com.example.demo.entities.Trainer;

import java.util.Date;

public class TrainerMeetDTO {
    private Trainer trainer;
    private Client client;
    private Date date;

    public Trainer getTrainer() {
        return trainer;
    }

    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }
}
