package com.poo.backend.dto;

import com.poo.backend.entities.Discipline;

public class DisciplineDTO {
    private final Long id;
    private final String code;
    private final String name;
    private final String url;
    private final DepartmentDTO department;

    public DisciplineDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.name = discipline.getName();
        this.code = discipline.getCode();
        this.url = discipline.getUrl();
        this.department = new DepartmentDTO(discipline.getDepartment());
    }

    public DisciplineDTO(Long id, String code, String name, String url, DepartmentDTO department) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.url = url;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }
}
