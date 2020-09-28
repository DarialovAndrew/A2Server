package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public final class GroupMeet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Client> clients;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Trainer trainer;
    private Date date;
    private int maxClients;

    public GroupMeet(Trainer trainer, Date date, int maxClients) {
        this.clients = new ArrayList<Client>();
        this.trainer = trainer;
        this.date = date;
        this.maxClients = maxClients;
    }

    public GroupMeet() {
        maxClients = -1;
    }

    public UUID getId() {
        return id;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        String s = "";
        for (Client client : clients) {
            s += client.toString() + "\n";

        }
        return "GroupMeeting with " + this.trainer + " max participants: " + this.maxClients + " Date: " + this.date.toString() + "\nparticipants:\n" + s;
    }

}
