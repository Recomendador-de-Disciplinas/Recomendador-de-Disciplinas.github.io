package com.poo.backend.repositories;

import com.poo.backend.entities.RequisitesByCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class RequisitesByCourseRepositoryTest {

    @Autowired
    private RequisitesByCourseRepository requisitesByCourseRepo;

    private void setupTestFindAllGroupedByCourseCode() {
        List<RequisitesByCourse> requisites = new ArrayList<>();
        requisites.add(new RequisitesByCourse(("45052")));
        requisites.add(new RequisitesByCourse(("45052")));
        requisites.add(new RequisitesByCourse(("94099")));
        requisites.add(new RequisitesByCourse(("94099")));

        requisitesByCourseRepo.saveAll(requisites);
    }
    @Test
    public void testFindAllGroupedByCourseCode() {
        setupTestFindAllGroupedByCourseCode();
        List<String> courseCodes = requisitesByCourseRepo.findAllGroupedByCourseCode();
        assertEquals(2, courseCodes.size());
    }
}