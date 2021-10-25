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

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchDataFromJson {

  @Autowired
  private DepartmentRepository departmentRepo;
  @Autowired
  private DisciplineRepository disciplineRepo;
  @Autowired
  private RequisiteByCourseRepository requisiteByCourseRepo;
  @Autowired
  private RequisiteRepository requisiteRepo;

  @PostConstruct
  public void run() {
    System.out.println("\n##### Starting fetch data from JSON #####");
    try {
      if (!this.emptyDatabase()) {
        System.out.println("\n##### Database already has data #####");
        return;
      }

      FileReader file = new FileReader("./src/main/resources/ach.json");
      JSONParser parser = new JSONParser();
      JSONArray departments = (JSONArray) parser.parse(file);

      generateDepartments(departments);

    } catch (Exception e) {
      System.out.println("ERROR:" + e.getMessage());
    } finally {
      System.out.println("##### Finish fetch data from JSON #####\n");
    }
  }

  private Boolean emptyDatabase() {
    return (departmentRepo.count() == 0 || disciplineRepo.count() == 0 || requisiteByCourseRepo.count() == 0
        || requisiteRepo.count() == 0);
  }

  private void generateDepartments(JSONArray departments) {
    List<Department> data = new ArrayList<>();
    for (int i = 0; i < departments.size(); i++) {
      JSONObject rawDepartment = (JSONObject) departments.get(i);

      String name, code, url;
      name = (String) rawDepartment.get("name");
      code = (String) rawDepartment.get("code");
      url = (String) rawDepartment.get("url");
      Department department = new Department(name, code, url);

      data.add(department);

    }

    departmentRepo.saveAll(data);

    for (int i = 0; i < departments.size(); i++) {
      JSONObject rawDepartment = (JSONObject) departments.get(i);
      Department department = data.get(i);
      List<Discipline> disciplines = generateDisciplines((JSONArray) rawDepartment.get("disciplines"), department);
      department.setDisciplines(disciplines);
    }

    departmentRepo.saveAll(data);
  }

  private List<Discipline> generateDisciplines(JSONArray disciplines, Department department) {
    List<Discipline> data = new ArrayList<>();
    for (int i = 0; i < disciplines.size(); i++) {
      JSONObject rawDiscipline = (JSONObject) disciplines.get(i);

      String name, code, url;
      name = (String) rawDiscipline.get("name");
      code = (String) rawDiscipline.get("code");
      url = (String) rawDiscipline.get("url");
      Discipline discipline = new Discipline(name, code, url);
      discipline.setDepartment(department);

      data.add(discipline);
    }

    disciplineRepo.saveAll(data);

    for (int i = 0; i < disciplines.size(); i++) {
      JSONObject rawDiscipline = (JSONObject) disciplines.get(i);
      Discipline discipline = data.get(i);
      List<RequisiteByCourse> requisites = generateRequisitesByCourses((JSONArray) rawDiscipline.get("requisites"),
          discipline);
      discipline.setRequisites(requisites);
    }

    disciplineRepo.saveAll(data);

    return data;
  }

  private List<RequisiteByCourse> generateRequisitesByCourses(JSONArray courses, Discipline discipline) {
    List<RequisiteByCourse> data = new ArrayList<>();
    for (int i = 0; i < courses.size(); i++) {
      JSONObject rawCourse = (JSONObject) courses.get(i);

      String code = (String) rawCourse.get("courseCode");
      RequisiteByCourse course = new RequisiteByCourse(code);
      course.setDiscipline(discipline);

      data.add(course);
    }

    requisiteByCourseRepo.saveAll(data);

    for (int i = 0; i < courses.size(); i++) {
      JSONObject rawCourse = (JSONObject) courses.get(i);
      RequisiteByCourse course = data.get(i);
      List<Requisite> requisites = generateRequisites((JSONArray) rawCourse.get("disciplines"), course);
      course.setRequisites(requisites);
    }

    requisiteByCourseRepo.saveAll(data);

    return data;
  }

  private List<Requisite> generateRequisites(JSONArray requisites, RequisiteByCourse course) {
    List<Requisite> data = new ArrayList<>();
    for (int i = 0; i < requisites.size(); i++) {
      JSONObject rawRequisite = (JSONObject) requisites.get(i);

      String discipline, type;
      discipline = (String) rawRequisite.get("discipline");
      type = (String) rawRequisite.get("type");
      Requisite requisite = new Requisite(discipline, type);
      requisite.setRequisiteByCourse(course);

      data.add(requisite);
    }
    requisiteRepo.saveAll(data);
    return data;
  }
}
