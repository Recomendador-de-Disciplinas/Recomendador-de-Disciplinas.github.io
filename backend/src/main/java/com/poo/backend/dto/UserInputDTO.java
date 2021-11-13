package com.poo.backend.dto;


import java.util.List;

public class UserInputDTO {
    private final List<Long> departmentsId;
    private final List<String> keywords;
    private List<String> disciplinesCode;
    private String courseCode;

    public UserInputDTO(List<Long> departmentsId, List<String> keywords) {
        this.departmentsId = departmentsId;
        this.keywords = keywords;
    }

    public UserInputDTO(List<Long> departmentsId, List<String> disciplinesCode, List<String> keywords, String courseCode) {
        this.departmentsId = departmentsId;
        this.disciplinesCode = disciplinesCode;
        this.keywords = keywords;
        this.courseCode = courseCode;
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

    public String getCourseCode() {
        return courseCode;
    }
}
