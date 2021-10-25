package com.poo.backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "requisite_by_course")
public class RequisiteByCourse {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String courseCode;

  @ManyToOne
  private Discipline discipline;

  @OneToMany
  private List<Requisite> requisites;

  public RequisiteByCourse() {

  }

  public RequisiteByCourse(String courseCode) {
    this.courseCode = courseCode;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public List<Requisite> getRequisites() {
    return requisites;
  }

  public void setRequisites(List<Requisite> requisites) {
    this.requisites = requisites;
  }

  public Discipline getDiscipline() {
    return discipline;
  }

  public void setDiscipline(Discipline discipline) {
    this.discipline = discipline;
  }
}
