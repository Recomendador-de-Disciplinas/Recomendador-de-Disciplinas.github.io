package com.poo.backend.controllers;

import java.util.List;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService service;

  @GetMapping
  public List<DepartmentDTO> findAll() {
    return service.findAll();
  }
}
