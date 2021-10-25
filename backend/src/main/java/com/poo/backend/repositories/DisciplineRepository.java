package com.poo.backend.repositories;

import java.util.List;

import com.poo.backend.entities.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

  @Query("SELECT * " +
    " FROM discipline " +
    " WHERE discipline.department_id IN (:ids)"
  )
  public List<Discipline> findByDepartments(@Param("ids") List<Long> ids);
}
