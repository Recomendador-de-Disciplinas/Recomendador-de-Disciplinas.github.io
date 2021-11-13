package com.poo.backend.repositories;

import com.poo.backend.entities.RequisitesByCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequisitesByCourseRepository extends JpaRepository<RequisitesByCourse, Long> {
    @Query("SELECT req.courseCode " +
            " FROM requisites_by_course AS req " +
            " GROUP BY req.courseCode")
    List<String> findAllGroupedByCourseCode();
}
