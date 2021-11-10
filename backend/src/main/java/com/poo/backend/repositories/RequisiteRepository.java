package com.poo.backend.repositories;

import com.poo.backend.entities.Requisite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisiteRepository extends JpaRepository<Requisite, Long> {
}
