package com.poo.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.dto.DisciplineDTO;
import com.poo.backend.dto.UserInputDTO;
import com.poo.backend.services.DepartmentService;
import com.poo.backend.services.DisciplineService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
    return disciplineService.findAllByDepartmentsId(ids);
  }
}
