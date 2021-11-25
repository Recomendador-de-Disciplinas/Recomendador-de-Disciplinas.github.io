package com.poo.backend.controllers;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.dto.DisciplineWithReqsDTO;
import com.poo.backend.dto.DisciplineWithoutReqsDTO;
import com.poo.backend.dto.RequisitesByCourseDTO;
import com.poo.backend.entities.Requisite;
import com.poo.backend.entities.RequisitesByCourse;
import com.poo.backend.services.DisciplineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DisciplineControllerTest {

    private final DepartmentDTO department = new DepartmentDTO(1L, "MAC", "Departamento de Ciência da Computação", "Bar");
    private DisciplineController controller;
    @Mock
    private DisciplineService service;

    @BeforeEach
    public void setup() {
        controller = new DisciplineController(service);
    }

    private List<DisciplineWithoutReqsDTO> setupTestGetRecommendations() {
        List<DisciplineWithoutReqsDTO> disciplines = List.of(
                new DisciplineWithoutReqsDTO(1L, "MAC0110", "Introdução à Computação", "", department),
                new DisciplineWithoutReqsDTO(2L, "MAC0444", "Sistemas Baseados em Conhecimento", "", department),
                new DisciplineWithoutReqsDTO(3L, "MAC0413", "Tópicos Avançados de Programação Orientada a Objetos", "", department),
                new DisciplineWithoutReqsDTO(4L, "MAC0219", "Computação Paralela e Concorrente", "", department),
                new DisciplineWithoutReqsDTO(5L, "MAC0425", "Inteligência Artificial", "", department));
        Mockito.when(service.findAllByDepartmentsId(Mockito.anyList())).thenReturn(disciplines);

        return disciplines;
    }

    @Test
    @DisplayName("it returns the correct recommended disciplines when used correct inputs")
    public void testGetRecommendations() {
        List<DisciplineWithoutReqsDTO> disciplines = setupTestGetRecommendations();
        List<DisciplineWithoutReqsDTO> expected = new ArrayList<>(disciplines);
        expected.remove(1);
        expected.remove(3);

        List<DisciplineWithoutReqsDTO> result = controller.getRecommendations(List.of(department.getId()),
                List.of("computação", "orientada a objetos"));

        expected.sort(Comparator.comparing(DisciplineWithoutReqsDTO::getName));
        result.sort(Comparator.comparing(DisciplineWithoutReqsDTO::getName));
        Assertions.assertEquals(expected.toString(), result.toString());
    }

    private List<DisciplineWithReqsDTO> setupTestGetPossibleRecommendations() {
        RequisitesByCourse bcc = new RequisitesByCourse("45052");
        RequisitesByCourse bcc2 = new RequisitesByCourse("45052");
        bcc.setRequisites(List.of(
                new Requisite("MAC0338 - Análise de Algoritmos", "requisito")
        ));
        bcc2.setRequisites(List.of(
                new Requisite("MAC0323 - Algoritmos e Estruturas de Dados II", "requisito")
        ));

        List<DisciplineWithReqsDTO> disciplines = List.of(
                new DisciplineWithReqsDTO(1L, "MAC0351", "Algoritmos em Bioinformática", "", new ArrayList<>()),
                new DisciplineWithReqsDTO(2L, "MAC0414", "Autômatos, Computabilidade e Complexidade", "", List.of(new RequisitesByCourseDTO(bcc))),
                new DisciplineWithReqsDTO(3L, "MAC0413", "Análise de Algoritmos", "", List.of(new RequisitesByCourseDTO(bcc2))));
        Mockito.when(service.findAllWithRequisitesByDepartmentsId(Mockito.anyList())).thenReturn(disciplines);

        return disciplines;
    }

    @Test
    @DisplayName("it returns the correct possible recommended disciplines when used correct inputs")
    public void testGetPossibleRecommendations() {
        List<DisciplineWithReqsDTO> disciplines = setupTestGetPossibleRecommendations();
        List<DisciplineWithReqsDTO> expected = new ArrayList<>(disciplines);
        expected.remove(1);
        List<DisciplineWithReqsDTO> result = controller.getPossibleRecommendations(List.of(department.getId()),
                List.of("algoritmos"),
                List.of("MAC0110", "MAC0121", "MAC0323"),
                "45052");

        expected.sort(Comparator.comparing(DisciplineWithReqsDTO::getName));
        result.sort(Comparator.comparing(DisciplineWithReqsDTO::getName));
        Assertions.assertEquals(expected.toString(), result.toString());
    }
}