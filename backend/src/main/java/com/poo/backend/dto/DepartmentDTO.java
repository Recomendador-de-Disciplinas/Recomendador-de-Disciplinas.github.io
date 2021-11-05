package com.poo.backend.dto;

import com.poo.backend.entities.Department;

public class DepartmentDTO {
    private final Long id;
    private final String code;
    private final String name;
    private final String url;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.code = department.getCode();
        this.name = department.getName();
        this.url = department.getUrl();
    }

    public DepartmentDTO(Long id, String code, String name, String url) {
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