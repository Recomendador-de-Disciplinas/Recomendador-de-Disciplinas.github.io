package com.poo.backend.dto;


import java.util.List;

public class UserInputDTO {
    private final List<DepartmentDTO> departments;
    private final List<String> keywords;

    public UserInputDTO(List<DepartmentDTO> departments, List<String> keywords) {
        this.departments = departments;
        this.keywords = keywords;
    }

    public List<DepartmentDTO> getDepartments() {
        return departments;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
