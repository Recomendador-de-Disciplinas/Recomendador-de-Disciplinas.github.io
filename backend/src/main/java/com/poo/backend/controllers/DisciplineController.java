package com.poo.backend.controllers;

import java.util.ArrayList;
import java.util.List;
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

  @Autowired
  private DisciplineService disciplineService;

  @GetMapping
  public List<DisciplineDTO> findAll() {
    return disciplineService.findAll();
  }

  @PostMapping(path = "/recommendations")
  public List<DisciplineDTO> getRecommendations(@RequestBody UserInputDTO body) {
    List<Long>ids = body.getDepartments().stream().map(DepartmentDTO::getId).collect(Collectors.toList());
    List<DisciplineDTO> disciplines = disciplineService.findAllByDepartmentsId(ids);

    List<String> topics = body.getKeywords();
    List<String> disciplinesNames = disciplines.stream().map(DisciplineDTO::getName).collect(Collectors.toList());

    List<ExtractedResult> results = new ArrayList<>();
    topics.forEach(keyword -> {
      List<ExtractedResult> matches = FuzzySearch.extractAll(keyword, disciplinesNames);
      matches = matches.stream().filter(match -> match.getScore() > 80).collect(Collectors.toList());
      results.addAll(matches);
    });

    return results
            .stream()
            .map(result -> disciplines.get(result.getIndex()))
            .collect(Collectors.toList());
  }
}
