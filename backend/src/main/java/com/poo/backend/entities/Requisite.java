package com.poo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "requisite")
public class Requisite {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String discipline;
  private String type;

  @JsonBackReference
  @ManyToOne
  private RequisiteByCourse requisiteByCourse;

  public Requisite() {

  }

  public Requisite(String discipline, String type) {
    this.discipline = discipline;
    this.type = type;
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

  public RequisiteByCourse getRequisiteByCourse() {
    return requisiteByCourse;
  }

  public void setRequisiteByCourse(RequisiteByCourse requisiteByCourse) {
    this.requisiteByCourse = requisiteByCourse;
  }

}
