package com.poo.backend.controllers;

import com.poo.backend.services.RequisitesByCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/requisites")
public class RequisitesByCourseController {

    @Autowired
    private RequisitesByCourseService service;

    @GetMapping("/courses")
    public List<String> findAllCourseCodes() {
        return service.findAllCourseCodes();
    }
}
