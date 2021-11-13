package com.poo.backend.dto;

import com.poo.backend.entities.Discipline;

public class DisciplineWithoutReqsDTO extends DisciplineDTO {
    private final DepartmentDTO department;

    public DisciplineWithoutReqsDTO(Discipline discipline) {
        super(discipline);
        this.department = new DepartmentDTO(discipline.getDepartment());
    }

    public DisciplineWithoutReqsDTO(Long id, String code, String name, String url, DepartmentDTO department) {
        super(id, code, name, url);
        this.department = department;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }
}
