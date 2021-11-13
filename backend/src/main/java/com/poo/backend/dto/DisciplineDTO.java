package com.poo.backend.dto;

import com.poo.backend.entities.Discipline;

public class DisciplineDTO {
    private final Long id;
    private final String code;
    private final String name;
    private final String url;

    public DisciplineDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.name = discipline.getName();
        this.code = discipline.getCode();
        this.url = discipline.getUrl();
    }

    public DisciplineDTO(Long id, String code, String name, String url) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.url = url;
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
}
