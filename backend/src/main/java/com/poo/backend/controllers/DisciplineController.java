package com.poo.backend.controllers;

import java.util.*;
import java.util.stream.Collectors;

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

  private List<DisciplineDTO> disciplinesThatMatchWithKeywords(List<String> keywords, List<DisciplineDTO> disciplines) {
    List<String> disciplinesNames = disciplines.stream().map(DisciplineDTO::getName).collect(Collectors.toList());
    List<ExtractedResult> results = new ArrayList<>();
    keywords.forEach(keyword -> {
      List<ExtractedResult> matches = FuzzySearch.extractAll(keyword, disciplinesNames);
      matches = matches.stream().filter(match -> match.getScore() > 70).collect(Collectors.toList());
      results.addAll(matches);
    });

    return results
            .stream()
            .map(result -> disciplines.get(result.getIndex()))
            .collect(Collectors.toList());
  }

  private List<DisciplineDTO> removeDups(List<DisciplineDTO> disciplines) {
    Set<String> disciplinesCode = new HashSet<>();
    return disciplines.stream().filter(discipline -> {
      String code = discipline.getCode();
      return !disciplinesCode.contains(code) && (disciplinesCode.add(code));
    }).collect(Collectors.toList());
  }
}
