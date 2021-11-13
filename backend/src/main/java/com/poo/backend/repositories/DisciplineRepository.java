package com.poo.backend.repositories;

import com.poo.backend.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    List<Discipline> findAllByDepartmentIdIn(List<Long> ids);
}
