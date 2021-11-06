package com.poo.backend.controllers;

import com.poo.backend.dto.DepartmentDTO;
import com.poo.backend.dto.DisciplineDTO;
import com.poo.backend.dto.UserInputDTO;
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

  private final List<DepartmentDTO> departments = List
      .of(new DepartmentDTO(1L, "MAC", "Departamento de Ciência da Computação", "Bar"));
  private final List<DisciplineDTO> disciplines = List.of(
      new DisciplineDTO(1L, "MAC0110", "Introdução à Computação", "", departments.get(0)),
      new DisciplineDTO(2L, "MAC0444", "Sistemas Baseados em Conhecimento", "", departments.get(0)),
      new DisciplineDTO(3L, "MAC0413", "Tópicos Avançados de Programação Orientada a Objetos", "", departments.get(0)),
      new DisciplineDTO(4L, "MAC0219", "Computação Paralela e Concorrente", "", departments.get(0)),
      new DisciplineDTO(5L, "MAC0425", "Inteligência Artificial", "", departments.get(0)));

  @BeforeEach
  public void setup() {
    controller = new DisciplineController(service);
  }

  @Test
  public void testGetRecommendations() {
    Mockito.when(service.findAllByDepartmentsId(Mockito.anyList())).thenReturn(disciplines);

    List<DisciplineDTO> expected = new ArrayList<>(disciplines);
    expected.remove(1);
    expected.remove(3);

    UserInputDTO requestBody = new UserInputDTO(departments, List.of("computação", "orientada a objetos"));
    List<DisciplineDTO> result = controller.getRecommendations(requestBody);

    expected.sort(Comparator.comparing(DisciplineDTO::getName));
    result.sort(Comparator.comparing(DisciplineDTO::getName));
    Assertions.assertEquals(expected.toString(), result.toString());
  }
}