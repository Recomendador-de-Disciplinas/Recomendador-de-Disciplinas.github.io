package com.poo.backend.dto;


import java.util.List;

public class UserInputDTO {
    private final List<DepartmentDTO> departments;
    private final List<String> keywords;
    private final String codeCourse;

    public UserInputDTO(List<DepartmentDTO> departments, List<String> keywords, String codeCourse) {
        this.departments = departments;
        this.keywords = keywords;
        this.codeCourse = codeCourse;
    }

    public List<DepartmentDTO> getDepartments() {
        return departments;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getCodeCourse() {
        return codeCourse;
    }
}
