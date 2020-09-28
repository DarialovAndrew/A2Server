package com.example.demo.entities.DTO;

import com.example.demo.entities.Client;
import com.example.demo.entities.Trainer;

import java.util.Date;
import java.util.List;

public class GroupMeetDTO {
    private List<Client> clients;
    private Trainer trainer;
    private Date date;
    private int maxClients;

    public List<Client> getClients() {
        return clients;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Date getDate() {
        return date;
    }

    public int getMaxClients() {
        return maxClients;
    }
}
