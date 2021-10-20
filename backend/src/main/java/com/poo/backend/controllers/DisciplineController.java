package com.poo.backend.controllers;

import java.util.List;

import com.poo.backend.entities.Discipline;
import com.poo.backend.repositories.DisciplineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/disciplines")
@RestController
public class DisciplineController {
  
  @Autowired
  private DisciplineRepository repository;


  @GetMapping
  public List<Discipline> findAll() {
    return repository.findAll();
  }
}
