package com.poo.backend.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.entities.Department;
import com.poo.backend.repositories.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepo;

  public List<DepartmentDTO> findAll() {
    List<Department> departments = departmentRepo.findAll();
    return departments.stream().map(dep -> new DepartmentDTO(dep)).collect(Collectors.toList());
  }
}
