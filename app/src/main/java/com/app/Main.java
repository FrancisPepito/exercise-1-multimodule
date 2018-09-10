package com.app;

import com.service.TableServiceImpl;
import com.model.Table;
import java.util.*;
public class Main{

	public static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args){
		TableServiceImpl tableService = new TableServiceImpl();
		boolean exit=false;
		Table table= new Table();
		System.out.print("Enter number of rows: ");
		int rows = scanner.nextInt();
		System.out.print("Enter number of columns: ");
		int cols = scanner.nextInt();
		table.setCells(tableService.newTable(rows,cols));
		tableService.printCells(table);

		while(!exit){
			System.out.println("1)Search\n2)Edit\n3)Print\n4)Reset\n5)Exit");
			int choice=scanner.nextInt();

			switch(choice){
				case 1:
					System.out.print("Enter string to be searched: ");
					String substring=scanner.next();
					tableService.search(table,substring);
					break;
				case 2:
					System.out.print("Enter row: ");
					rows = scanner.nextInt();
					System.out.print("Enter colum: ");
					cols = scanner.nextInt();
					String value = scanner.nextLine();
					table.setCells(tableService.edit(table,rows,cols,value));
					break;
				case 3:
					tableService.printCells(table);
					break;
				case 4:
					System.out.print("Enter number of rows: ");
					rows = scanner.nextInt();
					System.out.print("Enter number of columns: ");
					cols = scanner.nextInt();
					table.setCells(tableService.newTable(rows,cols));
					tableService.printCells(table);
					break;
				case 5:
					exit=true;
					break;
				default:
					break;

			}
		}
	}//End method main
}//End exercise class
