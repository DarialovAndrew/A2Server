package com.example.demo.repository;

import com.example.demo.entities.GroupMeet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupMeetRepository extends JpaRepository<GroupMeet, UUID> {
}
