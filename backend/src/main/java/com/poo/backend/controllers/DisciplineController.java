package com.poo.backend.controllers;

import java.util.List;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.dto.DisciplineDTO;
import com.poo.backend.services.DepartmentService;
import com.poo.backend.services.DisciplineService;

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

  @Autowired
  private DepartmentService departmentService;

  @GetMapping
  public List<DisciplineDTO> findAll() {
    return disciplineService.findAll();
  }

  /* @PostMapping
  public List<DisciplineDTO> getRecommendations(@RequestBody List<DepartmentDTO> departments) {
    List<DepartmentDTO> allDepartments = departmentService.getByIds();

  } */
}
