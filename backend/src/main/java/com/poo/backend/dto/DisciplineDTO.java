package com.poo.backend.dto;

import com.poo.backend.entities.Discipline;

public class DisciplineDTO {
  private Long id;
  private String code;
  private String name;
  private String url;
  private DepartmentDTO department;

  public DisciplineDTO(Discipline discipline) {
    this.id = discipline.getId();
    this.name = discipline.getName();
    this.code = discipline.getCode();
    this.url = discipline.getUrl();
    this.department = new DepartmentDTO(discipline.getDepartment());
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
