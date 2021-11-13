package com.poo.backend.dto;

import com.poo.backend.entities.Requisite;

public class RequisiteDTO {
    private final Long id;
    private final String discipline;
    private final String type;

    public RequisiteDTO(Requisite requisite) {
        this.id = requisite.getId();
        this.discipline = requisite.getDiscipline();
        this.type = requisite.getType();
    }

    public Long getId() {
        return id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getType() {
        return type;
    }
}
