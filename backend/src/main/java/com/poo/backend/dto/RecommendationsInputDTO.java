package com.poo.backend.dto;


import java.util.List;

public class RecommendationsInputDTO {
    private final List<Long> departmentsId;
    private final List<String> keywords;

    public RecommendationsInputDTO(List<Long> departmentsId, List<String> keywords) {
        this.departmentsId = departmentsId;
        this.keywords = keywords;
    }

    public List<Long> getDepartmentsId() {
        return departmentsId;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
