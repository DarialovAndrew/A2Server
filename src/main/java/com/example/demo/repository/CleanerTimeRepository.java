package com.example.demo.repository;

import com.example.demo.entities.CleanerTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CleanerTimeRepository extends JpaRepository<CleanerTime, UUID> {
}
