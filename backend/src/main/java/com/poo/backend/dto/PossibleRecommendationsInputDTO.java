package com.poo.backend.dto;

import java.util.List;

public class PossibleRecommendationsInputDTO {
    private final List<Long> departmentsId;
    private final List<String> keywords;
    private final List<String> disciplinesCode;
    private final String courseCode;


    public PossibleRecommendationsInputDTO(List<Long> departmentsId, List<String> disciplinesCode, List<String> keywords, String courseCode) {
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
