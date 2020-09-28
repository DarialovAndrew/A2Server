package com.example.demo.repository;

import com.example.demo.entities.TrainerMeet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainerMeetRepository extends JpaRepository<TrainerMeet, UUID> {
}
