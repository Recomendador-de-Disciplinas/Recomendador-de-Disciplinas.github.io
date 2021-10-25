package com.poo.backend.services;

import static org.junit.jupiter.api.Assertions.*;

import com.poo.backend.entities.Discipline;
import com.poo.backend.repositories.DisciplineRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class DisciplineServiceTest {

  @Autowired
  private DisciplineService service;

  @Autowired
  private DisciplineRepository repo;

  @Test
  public void createAndReturnNewField() {
    repo.save(new Discipline("Fodase", "AFE", "meupau.com"));
    assertEquals(1, repo.count());
  }
}
