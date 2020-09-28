package com.example.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public final class CleanerTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cleaner cleaner;
    private Date date;

    public CleanerTime(Cleaner cleaner, Date date) {
        this.cleaner = cleaner;
        this.date = date;
    }

    public CleanerTime() {
    }

    public UUID getId() {
        return id;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return this.cleaner.getName() + " works on " + this.date.toString() + "\n";
    }
}
