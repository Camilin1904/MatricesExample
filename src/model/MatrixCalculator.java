package model;

import java.util.ArrayList;
import java.lang.Math;

public class MatrixCalculator {
	
	private ArrayList<int[][]> numericMatrices;
	private ArrayList<String[][]> stringMatrices;
	private Student[][] students;
	private String[][] table;
	
	public MatrixCalculator() {
		numericMatrices= new ArrayList<int[][]>();
		stringMatrices= new ArrayList<String[][]>();
		students = new Student[10][10];
		table = new String[101][5];
		table[0][0] = "                  ";
		table[0][1] = "       Name       ";
		table[0][2] = "        Age       ";
		table[0][3] = "      Average     ";
		table[0][4] = "    Student ID    ";
		
	}
	
	public String showMatrices() {
		String out="";
		out += "Numeric matrices \n";
		for(int i=0; i< numericMatrices.size(); i++) {
			out+= printNumeric(numericMatrices.get(i)) + "\n";
		}
		out += "String matrices \n";
		for(int i=0; i< stringMatrices.size(); i++) {
			out+= printString(stringMatrices.get(i)) + "\n";
		}
		
		return out;
	}

	private String printString(String[][] matrix) {
		String print ="";
		for (int i=0; i< matrix.length; i++ ) { // filas numbers.length
			for (int j = 0; j < matrix[0].length; j++) { //columnas numbers[0].length
				print += matrix[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}

	private String printNumeric(int[][] numbers) {
		String print ="";
		for (int i=0; i< numbers.length; i++ ) { // filas numbers.length
			for (int j = 0; j < numbers[0].length; j++) { //columnas numbers[0].length
				print += numbers[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}
	
	

	public String createMatrix(int type, int rows, int columns) {
		String out="";
		switch(type) {
		case 1: //numeric Matrix
			int [][] newMatrix;
			newMatrix= new int[rows][columns];
			for (int counter=0; counter<rows; counter++){
				for (int counter2=0; counter2<columns; counter2++){
					newMatrix[counter][counter2] = (int)(Math.random()*(100)+1);	
				}
			}
			numericMatrices.add(newMatrix);
			out = printNumeric(newMatrix);
			
			break;
		case 2:
			String [][] newStringMatrix;
			newStringMatrix= new String[rows][columns];
			char random = 0;
			for (int counter=0; counter<rows; counter++){
				for (int counter2=0; counter2<columns; counter2++){
					random = (char)((int)(66+Math.random()*(25)));
					newStringMatrix[counter][counter2] = "" + random;
				}
			}
			stringMatrices.add(newStringMatrix);
			out = printString(newStringMatrix);

			break;
		}
		
		return out;
		
	}
	
	public void addNumeric (int[][] numMatrix) {
		numericMatrices.add(numMatrix);
	}

	public void addString (String[][] strMatrix) {
		stringMatrices.add(strMatrix);
	}

	public int FindFirstEmptyLane(int lane){
		int index = -1;
		for (int counter=0; counter<10&&index==-1; counter++){
			if (students[counter][lane]==null){
				index = counter;
			}
		}
		return index;
	}

	public boolean addStudent(String name, int age, double average, String id, double[][] grades){
		int holder;
		NoteSubject[][] notes = new NoteSubject[3][3];
		boolean success = false;
		for (int counter=0; counter<3; counter++){
			notes[counter][0] = new NoteSubject(("Parcial" + (counter+1)), grades[counter][0], "Matematicas Aplicadas", 4);
			notes[counter][1] = new NoteSubject(("Parcial" + (counter+1)), grades[counter][1], "APO 1", 3);
			notes[counter][2] = new NoteSubject(("Parcial" + (counter+1)), grades[counter][2], "Ingenieria de Software", 2);
		}
		for (int counter=0; counter<10&&!success; counter++){
			holder = FindFirstEmptyLane(counter);
			if (holder>=0){
				students[holder][counter] = new Student(name, age, average, id, notes);
				success = true;
				addStudentToTable(students[holder][counter]);
			}
		}
		return success;
	}

	public int FindEmptyTable(){
		int index = -1;
		for (int counter=0; counter<100&&index==-1; counter++){
			if (table[counter][0]==null){
				index = counter;
			}
		}
		return index;
	}
	public void addStudentToTable(Student student){
		int position = FindEmptyTable();
		if(position>0){
			table[position][0] = "Student " + position;
			table[position][1] = student.getName();
			table[position][2] = student.getAge() + "";
			table[position][3] = student.getAverage() + "";
			table[position][4] = student.getId();
		}
	}
	public String PrintTable(){
		String message = " __________________  __________________  __________________  __________________  __________________ \n", dataHolder = "";
		int lengthDifference = 0; 
		for (int counter=0; counter<100&&dataHolder!=null; counter++){
			for (int counter2=0; counter2<5&&dataHolder!=null; counter2++){
				dataHolder = table[counter][counter2];
				if (dataHolder!=null){
					lengthDifference = Math.abs(dataHolder.length()-18);
					for (int counter3=0; counter3<lengthDifference; counter3++){
						dataHolder += " ";
					}
					lengthDifference = 0;
					message += "|" + dataHolder + "|";
				}
			}
			if (dataHolder!=null){
				message += "\n ------------------  ------------------  ------------------  ------------------  ------------------ \n";
			}
		}
		return message;
	}
	public double getAverage(int studentRow, int studentColumn){
		return students[studentRow][studentColumn].getAverage();
	}	

	public int[] FindStudentById(String id){
		int[] ids = null;
		for (int counter=0; counter<10; counter++){
			for (int counter2=0; counter2<10; counter2++){
				if (students[counter][counter2] != null && students[counter][counter2].getId().equals(id)){
					ids = new int[2];
					ids[0] = counter;
					ids[1] = counter2;
				}
			}
		}
		return ids;
	}

	public String PrintGrades(int row, int column){
		return students[row][column].PrintGrades();
	}

}
