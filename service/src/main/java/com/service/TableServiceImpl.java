package com.service;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

import com.model.Table;

public class TableServiceImpl implements TableServiceInterface{

		private Scanner scanner = new Scanner(System.in);
		public ArrayList<ArrayList<String>> newTable(int rows, int cols){
			Random random = new Random();
			String randomString;
			ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>();

			for(int i=0;i<rows;i++){
				cells.add(new ArrayList<String>());
				for(int j=0;j<cols;j++){
					randomString = String.valueOf((char) (random.nextInt(93)+33));
					randomString += String.valueOf((char) (random.nextInt(93)+33));
					randomString += String.valueOf((char) (random.nextInt(93)+33));
					cells.get(i).add(randomString);
				}
			}
			return cells;

		}//End method newTale

		public void printCells(Table table){
			ArrayList<ArrayList<String>> cells = table.getCells();

			for (ArrayList<String> row : cells) {
				for (String cell : row) {
					System.out.print(cell+ " ");
				}
				System.out.println();
			}
		}//End method printCells

		public void search(Table table,String substring) {
			int occurrence=0;
			ArrayList<ArrayList<String>> cells = table.getCells();

			for(int i=0;i<cells.size();i++) {
				for(int j=0;j<cells.get(i).size();j++) {
					for(int k=0;k<=cells.get(i).get(j).length()-substring.length();k++) {
						if(substring.equals(cells.get(i).get(j).substring(k,substring.length()+k)))
							occurrence++;
					}
					if(occurrence>0) {
						System.out.println(occurrence+" occurrence(s) at ["+i+","+j+"]");
					}
					occurrence=0;
				}
			}
		}//End method search

		public ArrayList<ArrayList<String>> edit(Table table,int row, int col,String value){
			System.out.print(table.getCells().get(row).get(col)+"->");
			table.getCells().get(row).set(col,value);

			System.out.println("Cell successfully edited");

			return table.getCells();
		}//End method edit
}
