package com.poo.backend.dto;

import com.poo.backend.entities.Requisite;
import com.poo.backend.entities.RequisitesByCourse;

import java.util.List;
import java.util.stream.Collectors;

public class RequisitesByCourseDTO {
    private final Long id;
    private final String courseCode;
    private final List<RequisiteDTO> requisites;

    public RequisitesByCourseDTO(RequisitesByCourse requisitesByCourse) {
        this.id = requisitesByCourse.getId();
        this.courseCode = requisitesByCourse.getCourseCode();
        this.requisites = createRequisites(requisitesByCourse.getRequisites());
    }

    private List<RequisiteDTO> createRequisites(List<Requisite> requisites) {
        return requisites.stream().map(RequisiteDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public List<RequisiteDTO> getRequisites() {
        return requisites;
    }
}
