package com.poo.backend.dto;


import java.util.List;

public class UserInputDTO {
    private final List<Long> departmentsId;
    private List<String> disciplinesCode;
    private final List<String> keywords;
    private String codeCourse;

    public UserInputDTO(List<Long> departmentsId, List<String> keywords) {
        this.departmentsId = departmentsId;
        this.keywords = keywords;
    }

    public UserInputDTO(List<Long> departmentsId, List<String> disciplinesCode, List<String> keywords, String codeCourse) {
        this.departmentsId = departmentsId;
        this.disciplinesCode = disciplinesCode;
        this.keywords = keywords;
        this.codeCourse = codeCourse;
    }

    public List<Long> getDepartmentsId() {
        return departmentsId;
    }

    public List<String> getDisciplinesCode() {
        return disciplinesCode;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getCodeCourse() {
        return codeCourse;
    }
}
