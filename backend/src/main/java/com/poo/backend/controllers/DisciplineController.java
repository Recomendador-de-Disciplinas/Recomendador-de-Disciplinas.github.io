package com.poo.backend.controllers;

import java.util.List;

import com.poo.backend.dto.DisciplineDTO;
import com.poo.backend.services.DisciplineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

  @Autowired
  private DisciplineService service;

  @GetMapping
  public List<DisciplineDTO> findAll() {
    return service.findAll();
  }
}
