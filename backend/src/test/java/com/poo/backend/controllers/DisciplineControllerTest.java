package com.poo.backend.controllers;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.dto.DisciplineWithoutReqsDTO;
import com.poo.backend.dto.RecommendationsInputDTO;
import com.poo.backend.services.DisciplineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

  private DisciplineController controller;

  @Mock
  private DisciplineService service;

  private final DepartmentDTO department = new DepartmentDTO(1L, "MAC", "Departamento de Ciência da Computação", "Bar");
  private final List<DisciplineWithoutReqsDTO> disciplines = List.of(
      new DisciplineWithoutReqsDTO(1L, "MAC0110", "Introdução à Computação", "", department),
      new DisciplineWithoutReqsDTO(2L, "MAC0444", "Sistemas Baseados em Conhecimento", "", department),
      new DisciplineWithoutReqsDTO(3L, "MAC0413", "Tópicos Avançados de Programação Orientada a Objetos", "", department),
      new DisciplineWithoutReqsDTO(4L, "MAC0219", "Computação Paralela e Concorrente", "", department),
      new DisciplineWithoutReqsDTO(5L, "MAC0425", "Inteligência Artificial", "", department));

  @BeforeEach
  public void setup() {
    controller = new DisciplineController(service);
  }

  @Test
  public void testGetRecommendations() {
    Mockito.when(service.findAllByDepartmentsId(Mockito.anyList())).thenReturn(disciplines);

    List<DisciplineWithoutReqsDTO> expected = new ArrayList<>(disciplines);
    expected.remove(1);
    expected.remove(3);

    RecommendationsInputDTO requestBody = new RecommendationsInputDTO(List.of(department.getId()), List.of("computação", "orientada a objetos"));
    List<DisciplineWithoutReqsDTO> result = controller.getRecommendations(requestBody);

    expected.sort(Comparator.comparing(DisciplineWithoutReqsDTO::getName));
    result.sort(Comparator.comparing(DisciplineWithoutReqsDTO::getName));
    Assertions.assertEquals(expected.toString(), result.toString());
  }
}