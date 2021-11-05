package com.poo.backend.actions;

import javax.annotation.PostConstruct;

import com.poo.backend.entities.Department;
import com.poo.backend.entities.Discipline;
import com.poo.backend.entities.Requisite;
import com.poo.backend.entities.RequisiteByCourse;
import com.poo.backend.repositories.DepartmentRepository;
import com.poo.backend.repositories.DisciplineRepository;
import com.poo.backend.repositories.RequisiteByCourseRepository;
import com.poo.backend.repositories.RequisiteRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchDataFromJson {

    private final DepartmentRepository departmentRepo;
    private final DisciplineRepository disciplineRepo;
    private final RequisiteByCourseRepository requisiteByCourseRepo;
    private final RequisiteRepository requisiteRepo;

    @Autowired
    public FetchDataFromJson(DepartmentRepository departmentRepo, DisciplineRepository disciplineRepo,
            RequisiteByCourseRepository requisiteByCourseRepo, RequisiteRepository requisiteRepo) {
        this.departmentRepo = departmentRepo;
        this.disciplineRepo = disciplineRepo;
        this.requisiteByCourseRepo = requisiteByCourseRepo;
        this.requisiteRepo = requisiteRepo;
    }

    @PostConstruct
    public void run() {
        System.out.println("\n##### Starting fetch data from JSON #####");
        try {
            if (!this.emptyDatabase()) {
                System.out.println("\n##### Database already has data #####");
                return;
            }
            JSONArray departments = readFile();
            processEntities(departments);

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        } finally {
            System.out.println("##### Finish fetch data from JSON #####\n");
        }
    }

    protected JSONArray readFile() throws IOException, ParseException {
        String currentPath = new File("");
        FileReader file = new FileReader("./src/main/resources/data.json");
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(file);
    }

    private Boolean emptyDatabase() {
        return (departmentRepo.count() == 0 || disciplineRepo.count() == 0 || requisiteByCourseRepo.count() == 0
                || requisiteRepo.count() == 0);
    }

    private void processEntities(JSONArray departments) {
        List<Department> data = new ArrayList<>();
        for (Object dep : departments) {
            JSONObject departmentJson = (JSONObject) dep;

            String name, code, url;
            name = (String) departmentJson.get("name");
            code = (String) departmentJson.get("code");
            url = (String) departmentJson.get("url");
            Department department = new Department(name, code, url);

            data.add(department);
        }

        departmentRepo.saveAll(data);

        for (int i = 0; i < departments.size(); i++) {
            JSONObject departmentJson = (JSONObject) departments.get(i);
            Department department = data.get(i);
            List<Discipline> disciplines = generateDisciplines((JSONArray) departmentJson.get("disciplines"),
                    department);
            department.setDisciplines(disciplines);
        }

        departmentRepo.saveAll(data);
    }

    private List<Discipline> generateDisciplines(JSONArray disciplines, Department department) {
        List<Discipline> data = new ArrayList<>();
        for (Object disc : disciplines) {
            JSONObject disciplineJson = (JSONObject) disc;

            String name, code, url;
            name = (String) disciplineJson.get("name");
            code = (String) disciplineJson.get("code");
            url = (String) disciplineJson.get("url");
            Discipline discipline = new Discipline(name, code, url);
            discipline.setDepartment(department);

            data.add(discipline);
        }

        disciplineRepo.saveAll(data);

        for (int i = 0; i < disciplines.size(); i++) {
            JSONObject disciplineJson = (JSONObject) disciplines.get(i);
            Discipline discipline = data.get(i);
            List<RequisiteByCourse> requisites = generateRequisitesByCourses(
                    (JSONArray) disciplineJson.get("requisites"), discipline);
            discipline.setRequisites(requisites);
        }

        disciplineRepo.saveAll(data);

        return data;
    }

    private List<RequisiteByCourse> generateRequisitesByCourses(JSONArray requisitesByCourses, Discipline discipline) {
        List<RequisiteByCourse> data = new ArrayList<>();
        for (Object req : requisitesByCourses) {
            JSONObject requisitesByCourseJson = (JSONObject) req;

            String code = (String) requisitesByCourseJson.get("courseCode");
            RequisiteByCourse requisitesByCourse = new RequisiteByCourse(code);
            requisitesByCourse.setDiscipline(discipline);

            data.add(requisitesByCourse);
        }

        requisiteByCourseRepo.saveAll(data);

        for (int i = 0; i < requisitesByCourses.size(); i++) {
            JSONObject requisitesByCourseJson = (JSONObject) requisitesByCourses.get(i);
            RequisiteByCourse course = data.get(i);
            List<Requisite> requisites = generateRequisites((JSONArray) requisitesByCourseJson.get("disciplines"),
                    course);
            course.setRequisites(requisites);
        }

        requisiteByCourseRepo.saveAll(data);

        return data;
    }

    private List<Requisite> generateRequisites(JSONArray requisites, RequisiteByCourse requisiteByCourse) {
        List<Requisite> data = new ArrayList<>();
        for (Object req : requisites) {
            JSONObject requisiteJson = (JSONObject) req;

            String discipline, type;
            discipline = (String) requisiteJson.get("discipline");
            type = (String) requisiteJson.get("type");
            Requisite requisite = new Requisite(discipline, type);
            requisite.setRequisiteByCourse(requisiteByCourse);

            data.add(requisite);
        }
        requisiteRepo.saveAll(data);
        return data;
    }
}
