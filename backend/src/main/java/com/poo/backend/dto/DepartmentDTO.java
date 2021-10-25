package com.poo.backend.dto;

import com.poo.backend.entities.Department;

public class DepartmentDTO {
  private Long id;
  private String code;
  private String name;
  private String url;

  public DepartmentDTO(Department department) {
    this.id = department.getId();
    this.code = department.getCode();
    this.name = department.getName();
    this.url = department.getUrl();
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