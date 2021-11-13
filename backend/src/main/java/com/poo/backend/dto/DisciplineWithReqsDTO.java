package com.poo.backend.dto;

import com.poo.backend.entities.Discipline;
import com.poo.backend.entities.RequisitesByCourse;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplineWithReqsDTO extends DisciplineDTO {
    private final List<RequisitesByCourseDTO> requisites;

    public DisciplineWithReqsDTO(Discipline discipline) {
        super(discipline);
        this.requisites = createRequisites(discipline.getRequisites());
    }

    private List<RequisitesByCourseDTO> createRequisites(List<RequisitesByCourse> requisites) {
        return requisites.stream().map(RequisitesByCourseDTO::new).collect(Collectors.toList());
    }

    public List<RequisitesByCourseDTO> getRequisites() {
        return requisites;
    }
}
