package com.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.model.Table;
public interface TableServiceInterface {
	public ArrayList<ArrayList<String>> edit(Table table,int row, int col, String value);
	public void search(Table table,String substring);
	public void printCells(Table table);
	public ArrayList<ArrayList<String>> newTable(int rows,int cols);

}
