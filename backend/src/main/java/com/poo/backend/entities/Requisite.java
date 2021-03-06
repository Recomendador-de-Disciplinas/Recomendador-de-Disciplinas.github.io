package com.poo.backend.entities;

import javax.persistence.*;

@Entity(name = "requisite")
public class Requisite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String discipline;
    private String type;

    @ManyToOne
    private RequisitesByCourse requisitesByCourse;

    public Requisite() {

    }

    public Requisite(String discipline, String type) {
        this.discipline = discipline;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RequisitesByCourse getRequisiteByCourse() {
        return requisitesByCourse;
    }

    public void setRequisitesByCourse(RequisitesByCourse requisitesByCourse) {
        this.requisitesByCourse = requisitesByCourse;
    }
}
