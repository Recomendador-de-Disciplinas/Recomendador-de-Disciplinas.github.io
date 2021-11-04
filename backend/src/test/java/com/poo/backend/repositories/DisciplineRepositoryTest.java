package com.poo.backend.repositories;

import com.poo.backend.entities.Department;
import com.poo.backend.entities.Discipline;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class DisciplineRepositoryTest {

    @Autowired
    private DisciplineRepository disciplineRepo;
    @Autowired
    private DepartmentRepository departmentRepo;

    void setup_findAllByDepartmentIdIn() {
        List<Department> departments = new ArrayList<>();
        List<Discipline> disciplines = new ArrayList<>();
        departments.add(new Department("Foo", "FFF", ""));
        departments.add(new Department("Bar", "BBB", ""));
        departments.add(new Department("Test", "TTT", ""));
        disciplines.add(new Discipline("Foo001", "FFF0001", ""));
        disciplines.add(new Discipline("Foo002", "FFF0002", ""));
        disciplines.add(new Discipline("Bar001", "BBB0001", ""));
        disciplines.add(new Discipline("Test001", "TTT0001", ""));
        disciplines.get(0).setDepartment(departments.get(0));
        disciplines.get(1).setDepartment(departments.get(0));
        disciplines.get(2).setDepartment(departments.get(1));
        disciplines.get(3).setDepartment(departments.get(2));

        departmentRepo.saveAll(departments);
        disciplineRepo.saveAll(disciplines);
    }
    @Test
    void testFindAllByDepartmentIdIn() {
        setup_findAllByDepartmentIdIn();
        List<Long>ids = List.of(1L, 2L);
        assertEquals(3, disciplineRepo.findAllByDepartmentIdIn(ids).size());
    }
}