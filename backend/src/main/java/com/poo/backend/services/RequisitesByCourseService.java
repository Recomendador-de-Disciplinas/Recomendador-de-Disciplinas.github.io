package com.poo.backend.services;

import com.poo.backend.repositories.RequisitesByCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequisitesByCourseService {

    @Autowired
    RequisitesByCourseRepository requisiteRepo;

    public List<String> findAllCourseCodes() {
        return requisiteRepo.findAllGroupedByCourseCode();
    }
}
