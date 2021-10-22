package com.poo.backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "department")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String code;
  private String name;
  private String url;

  @JsonManagedReference
  @OneToMany
  private List<Discipline> disciplines;

  public Department() {
  }

  public Department(String name, String code, String url) {
    this.name = name;
    this.code = code;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Discipline> getDisciplines() {
    return disciplines;
  }

  public void setDisciplines(List<Discipline> disciplines) {
    this.disciplines = disciplines;
  }

}
