package com.poo.backend.dto;

import com.poo.backend.entities.Discipline;
import com.poo.backend.entities.RequisitesByCourse;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplineWithReqsDTO extends DisciplineDTO {
    private List<RequisitesByCourseDTO> requisites;

    public DisciplineWithReqsDTO(Discipline discipline) {
        super(discipline);
        this.requisites = createRequisites(discipline.getRequisites());
    }

    public DisciplineWithReqsDTO(Long id, String code, String name, String url, List<RequisitesByCourseDTO> requisites) {
        super(id, code, name, url);
        this.requisites = requisites;
    }

    private List<RequisitesByCourseDTO> createRequisites(List<RequisitesByCourse> requisites) {
        return requisites.stream().map(RequisitesByCourseDTO::new).collect(Collectors.toList());
    }

    public void setRequisites(List<RequisitesByCourseDTO> requisites) {
        this.requisites = requisites;
    }

    public List<RequisitesByCourseDTO> getRequisites() {
        return requisites;
    }
}
