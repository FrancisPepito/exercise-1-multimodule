package com.service;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Test;
import org.junit.Before;

import com.model.Table;

public class TableServiceTest{

  TableServiceImpl tableService = new TableServiceImpl();
  @Before
  public void setup() {
    Table table = new Table();
    MockitoAnnotations.initMocks(this);
  }

  @Mock
  Table tableMock = new Table();

  @Test
  public void testGenerateTable() {
    assertNotNull("NULL",tableService.newTable(5,5));
  }

  @Test
  public void testPrintCells() {
    ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>();
    cells.add(new ArrayList<String>());
    cells.get(0).add("123");
    cells.get(0).add("234");
    cells.get(0).add("345");
    when(tableMock.getCells()).thenReturn(cells);

    tableService.printCells(tableMock);
    verify(tableMock).getCells();
  }
  @Test
  public void testEditCells() {
      ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>();
      cells.add(new ArrayList<String>());
      cells.get(0).add("123");
      cells.get(0).add("234");
      cells.get(0).add("345");

      when(tableMock.getCells()).thenReturn(cells);
      cells.get(0).set(2,"132");
      assertEquals("ArrayList",cells,tableService.edit(tableMock,0,2,"132"));
  }

  @Test
  public void testSearch() {
        ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>();
        cells.add(new ArrayList<String>());
        cells.get(0).add("123");
        cells.get(0).add("234");
        cells.get(0).add("345");
        when(tableMock.getCells()).thenReturn(cells);
        tableService.search(tableMock,"1");
        verify(tableMock).getCells();
  }
}
