package com.poo.backend.repositories;

import java.util.List;

import com.poo.backend.entities.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    List<Discipline> findAllByDepartmentIdIn(List<Long> ids);
}
