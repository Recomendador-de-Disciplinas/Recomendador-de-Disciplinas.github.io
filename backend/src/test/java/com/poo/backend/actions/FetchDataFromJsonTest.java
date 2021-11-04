package com.poo.backend.actions;

import com.poo.backend.repositories.DepartmentRepository;
import com.poo.backend.repositories.DisciplineRepository;
import com.poo.backend.repositories.RequisiteByCourseRepository;
import com.poo.backend.repositories.RequisiteRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@ExtendWith(MockitoExtension.class)
class FetchDataFromJsonTest {

    private FetchDataFromJson fetcher;

    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    DisciplineRepository disciplineRepo;
    @Autowired
    private RequisiteByCourseRepository requisiteByCourseRepo;
    @Autowired
    private RequisiteRepository requisiteRepo;

    @BeforeEach
    void setup() {
        this.fetcher = new FetchDataFromJson(departmentRepo, disciplineRepo, requisiteByCourseRepo, requisiteRepo);
    }

    JSONArray setup_testRun() {
        JSONObject departamentData = new JSONObject();
        departamentData.put("name", "Foo");
        departamentData.put("code", "FFF");
        departamentData.put("url", "");

        List<JSONObject> disciplinesData = new ArrayList<>(List.of(new JSONObject(), new JSONObject()));
        disciplinesData.get(0).put("name", "Introdução à Foo");
        disciplinesData.get(0).put("code", "FFF0110");
        disciplinesData.get(0).put("url", "");
        disciplinesData.get(0).put("requisites", new ArrayList<>());
        disciplinesData.get(1).put("name", "Lógica Foo");
        disciplinesData.get(1).put("code", "FFF0259");
        disciplinesData.get(1).put("url", "");
        disciplinesData.get(1).put("requisites", new ArrayList<>());

        JSONArray disciplines = new JSONArray();
        disciplines.addAll(disciplinesData);
        departamentData.put("disciplines", disciplines);

        JSONArray dataJson = new JSONArray();
        dataJson.add(departamentData);
        return dataJson;
    }

    @Test
    void testRun() throws IOException, ParseException {
        JSONArray dataJson = setup_testRun();
        FetchDataFromJson spy = Mockito.spy(fetcher);
        Mockito.when(spy.readFile()).thenReturn(dataJson);
        spy.run();
        assertEquals(2, disciplineRepo.count());
    }
}