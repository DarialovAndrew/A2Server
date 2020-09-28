package com.example.demo.repository;

import com.example.demo.entities.Shower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowerRepository extends JpaRepository<Shower, UUID> {
}
