package com.poo.backend.actions;

import com.poo.backend.repositories.DepartmentRepository;
import com.poo.backend.repositories.DisciplineRepository;
import com.poo.backend.repositories.RequisiteRepository;
import com.poo.backend.repositories.RequisitesByCourseRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@ExtendWith(MockitoExtension.class)
class FetchDataFromJsonTest {

    @Autowired
    DisciplineRepository disciplineRepo;
    private FetchDataFromJson fetcher;
    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private RequisitesByCourseRepository requisiteByCourseRepo;
    @Autowired
    private RequisiteRepository requisiteRepo;

    @BeforeEach
    void setup() {
        this.fetcher = new FetchDataFromJson(departmentRepo, disciplineRepo, requisiteByCourseRepo, requisiteRepo);
    }

    JSONArray setupTestRun() {
        List<JSONObject> disciplinesJson = new ArrayList<>(List.of(new JSONObject(), new JSONObject()));
        disciplinesJson.get(0).put("name", "Introdução à Foo");
        disciplinesJson.get(0).put("code", "FFF0110");
        disciplinesJson.get(0).put("url", "");
        disciplinesJson.get(0).put("requisites", new JSONArray());
        disciplinesJson.get(1).put("name", "Lógica Foo");
        disciplinesJson.get(1).put("code", "FFF0259");
        disciplinesJson.get(1).put("url", "");
        disciplinesJson.get(1).put("requisites", new JSONArray());

        JSONObject departamentData = new JSONObject();
        departamentData.put("name", "Foo");
        departamentData.put("code", "FFF");
        departamentData.put("url", "");

        JSONArray disciplinesData = new JSONArray();
        disciplinesData.addAll(disciplinesJson);
        departamentData.put("disciplines", disciplinesData);

        JSONArray dataJson = new JSONArray();
        dataJson.add(departamentData);
        return dataJson;
    }

    @Test
    @DisplayName("it returns the correct data when fetching from json file")
    void testRun() throws IOException, ParseException {
        JSONArray dataJson = setupTestRun();
        FetchDataFromJson spy = Mockito.spy(fetcher);
        Mockito.when(spy.readFile()).thenReturn(dataJson);
        spy.run();
        assertEquals(2, disciplineRepo.count());
    }
}