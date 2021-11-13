package com.poo.backend.controllers;

import com.poo.backend.dto.DisciplineDTO;
import com.poo.backend.dto.DisciplineWithReqsDTO;
import com.poo.backend.dto.DisciplineWithoutReqsDTO;
import com.poo.backend.dto.UserInputDTO;
import com.poo.backend.search.SearchByExactMatch;
import com.poo.backend.search.SearchByFuzzy;
import com.poo.backend.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public List<DisciplineWithoutReqsDTO> findAll() {
        return disciplineService.findAll();
    }

    @PostMapping(path = "/recommendations")
    public List<DisciplineWithoutReqsDTO> getRecommendations(@RequestBody UserInputDTO body) {
        List<DisciplineWithoutReqsDTO> disciplines;
        List<String> disciplinesNames;
        List<Integer> disciplinesIndexes;

        disciplines = disciplineService.findAllByDepartmentsId(body.getDepartmentsId());

        disciplinesNames = disciplines.stream().map(DisciplineWithoutReqsDTO::getName).collect(Collectors.toList());
        disciplinesIndexes = disciplinesThatMatchWithKeywords(body.getKeywords(), disciplinesNames);
        disciplines = disciplinesIndexes.stream().map(disciplines::get).collect(Collectors.toList());

        return (List<DisciplineWithoutReqsDTO>) removeDups(disciplines);
    }

    @PostMapping(path = "/possible-recommendations")
    public List<DisciplineWithReqsDTO> getPossibleRecommendations(@RequestBody UserInputDTO body) {
        List<DisciplineWithReqsDTO> disciplines;
        List<String> disciplinesNames;
        List<Integer> disciplinesIndexes;

        disciplines = disciplineService.findAllWithRequisitesByDepartmentsId(body.getDepartmentsId());

        disciplinesNames = disciplines.stream().map(DisciplineWithReqsDTO::getName).collect(Collectors.toList());
        disciplinesIndexes = disciplinesThatMatchWithKeywords(body.getKeywords(), disciplinesNames);
        disciplines = disciplinesIndexes.stream().map(disciplines::get).collect(Collectors.toList());

        disciplines = (List<DisciplineWithReqsDTO>) removeDups(disciplines);

        return disciplines;
    }

    private List<Integer> disciplinesThatMatchWithKeywords(List<String> keywords,
                                                           List<String> disciplinesNames) {
        List<Integer> resultsIndex;
        List<String> fuzzyKeywords, exactMatchKeywords;

        fuzzyKeywords = keywords.stream().filter(keyword -> keyword.split(" ").length < 3).collect(Collectors.toList());
        exactMatchKeywords = keywords.stream().filter(keyword -> keyword.split(" ").length >= 3).collect(Collectors.toList());

        resultsIndex = new SearchByFuzzy().doSearch(fuzzyKeywords, disciplinesNames);
        resultsIndex.addAll(new SearchByExactMatch().doSearch(exactMatchKeywords, disciplinesNames));

        return resultsIndex;
    }

    private Object removeDups(Object rawDisciplines) {
        Set<String> disciplinesCode = new HashSet<>();
        List<DisciplineDTO> disciplines = (List<DisciplineDTO>) rawDisciplines;

        return disciplines.stream().filter(discipline -> {
            String code = discipline.getCode();
            return !disciplinesCode.contains(code) && (disciplinesCode.add(code));
        }).collect(Collectors.toList());
    }
}
