package com.vdarko.workshop.tdd.mock.example.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.vdarko.workshop.tdd.mock.example.Repository;

public class ServiceImplProtectedConstructorTest {

  /**
   * <b>GIVEN</b> records repository contains records</br>
   * <b>WHEN</b> service finds all</br>
   * <b>THEN</b> result contains all records from repository</br>
   */
  @Test
  public void testRecordsExist() {

    // GIVEN
    List<String> records = Arrays.asList("A", "B", "C");

    // WHEN
    Repository repository = mock(Repository.class);
    when(repository.findAllRecords()).thenReturn(records);

    ServiceImplProtectedConstructor service = new ServiceImplProtectedConstructor(repository);
    List<String> results = service.findAll();

    // THEN
    assertThat(results).isNotNull()//
    .containsExactlyElementsOf(records);
  }
}