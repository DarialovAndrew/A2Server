package com.example.demo.repository;

import com.example.demo.entities.Apparatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApparatusRepository extends JpaRepository<Apparatus, UUID> {
}
