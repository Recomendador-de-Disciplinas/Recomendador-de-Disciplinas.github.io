package com.poo.backend.controllers;

import java.text.Normalizer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.dto.DisciplineDTO;
import com.poo.backend.dto.UserInputDTO;
import com.poo.backend.services.DisciplineService;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public List<DisciplineDTO> findAll() {
        return disciplineService.findAll();
    }

    @PostMapping(path = "/recommendations")
    public List<DisciplineDTO> getRecommendations(@RequestBody UserInputDTO body) {
        List<DisciplineDTO> disciplines = disciplinesThatMatchWithDepartments(body.getDepartments());
        disciplines = disciplinesThatMatchWithKeywords(body.getKeywords(), disciplines);
        return removeDups(disciplines);
    }

    private List<DisciplineDTO> disciplinesThatMatchWithDepartments(List<DepartmentDTO> departments) {
        List<Long> ids = departments.stream().map(DepartmentDTO::getId).collect(Collectors.toList());
        return disciplineService.findAllByDepartmentsId(ids);
    }

    private String unaccent(String src) {
        return Normalizer.normalize(src, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    private void processKeyword(String keyword, List<String> disciplinesNames, List<Integer> normalResults,
            List<ExtractedResult> fuzzyResults) {
        if (keyword.split(" ").length >= 3) {
            // do search without fuzzy
            String lowerCaseKeyword = unaccent(keyword).toLowerCase();

            List<Integer> matches = IntStream.range(0, disciplinesNames.size()).mapToObj((index) -> {
                String discipline = disciplinesNames.get(index);
                return unaccent(discipline).toLowerCase().contains(lowerCaseKeyword) ? index : -1;
            }).filter(index -> index != -1).collect(Collectors.toList());
            normalResults.addAll(matches);

        } else {
            List<ExtractedResult> matches = FuzzySearch.extractAll(keyword, disciplinesNames);
            matches = matches.stream().filter(match -> match.getScore() >= 80).collect(Collectors.toList());
            fuzzyResults.addAll(matches);
        }
    }

    private List<DisciplineDTO> disciplinesThatMatchWithKeywords(List<String> keywords,
            List<DisciplineDTO> disciplines) {
        List<String> disciplinesNames = disciplines.stream().map(DisciplineDTO::getName).collect(Collectors.toList());
        List<ExtractedResult> fuzzyResults = new ArrayList<>();
        List<Integer> normalResults = new ArrayList<>();

        keywords.forEach(keyword -> {
            processKeyword(keyword, disciplinesNames, normalResults, fuzzyResults);
        });

        List<DisciplineDTO> results = new ArrayList<>();

        results.addAll(
                fuzzyResults.stream().map(result -> disciplines.get(result.getIndex())).collect(Collectors.toList()));

        results.addAll(normalResults.stream().map(index -> disciplines.get(index)).collect(Collectors.toList()));

        return results;
    }

    private List<DisciplineDTO> removeDups(List<DisciplineDTO> disciplines) {
        Set<String> disciplinesCode = new HashSet<>();
        return disciplines.stream().filter(discipline -> {
            String code = discipline.getCode();
            return !disciplinesCode.contains(code) && (disciplinesCode.add(code));
        }).collect(Collectors.toList());
    }
}
