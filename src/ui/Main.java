package ui;

import java.util.Scanner;

import model.MatrixCalculator;

public class Main {
	
	private Scanner sc;
	private MatrixCalculator calculator;
	
	public Main(){
		sc= new Scanner(System.in);
		calculator = new MatrixCalculator();
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to the matrix calculator");
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Main menu, please pick an option\n" +
				"(1) Create a matrix \n" +
				"(2) Show the contents of all matrices \n"+
				"(3) Numeric matrices\n"+
				"(4) String matrices\n" + 
				"(5) Register a Student\n" +
				"(6) Show table\n" + 
				"(7) Did a Student aprove?\n" +
				"(8) get a students grades\n" +
				"(0) To leave the application"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createMatrix();
			break;
		case 2:
			System.out.println(calculator.showMatrices());
			break;
	
		case 3:
			createNumericMatrix();
			break;

		case 4:
			createStringMatrix();
			break;
		case 5:
			addStudent();
			break;
		case 6:
			System.out.print(calculator.PrintTable())	;
			break;
		case 7:
			DidStudentAprove();
			break;
		case 8:
			printGrades();
			break;

		default:
			System.out.println("Error, wrong option");
		
		}
	

	}

	private void createMatrix() {
		System.out.println("Please select the type of matrix \n (1) Numeric matrix\n (2) String's matrix");
		int type= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please digit the number of rows");
		int rows= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please digit the number of columns");
		int columns= sc.nextInt();
		sc.nextLine();
		
		System.out.println("new matrix");
		System.out.println(calculator.createMatrix(type, rows, columns));
	}
	
	public void createNumericMatrix() {
		
		int row, col, num;
		
		System.out.println("Digite el num de filas");
		row= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite el num de columnas");
		col= sc.nextInt();
		sc.nextLine();
		
		int [][] tmp= new int[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.println( "What is the number you want to register in the " + i + 
					" " + j + " pos");
				num= sc.nextInt();
				sc.nextLine();
				tmp[i][j]=num;
			}
		}
		calculator.addNumeric(tmp);
		
		
	}

	public void createStringMatrix(){
		
		int row, col;
		String str = "";
		
		System.out.println("Digite el num de filas");
		row= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite el num de columnas");
		col= sc.nextInt();
		sc.nextLine();
		
		String [][] tmp= new String[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.println( "What is the value you want to register in the " + i + 
					" " + j + " pos");
				str= sc.next();
				sc.nextLine();
				tmp[i][j]=str;
			}
		}
		calculator.addString(tmp);
		
	}

	public void addStudent(){
				
		String name="",id="", holder="";
		double average=0;
		int age=0, number=1;
		double[][] grades = new double[3][3];
		double[] avgGrades = new double[3];

		System.out.println( "What is the name of the student? (No more than 18 letters)");
		name= sc.next();
		sc.nextLine();

		int k= name.length();
		if (k>18){
			do{
			
				System.out.println("The name is to long, write the name again.");
				name= sc.next();
				sc.nextLine();
				
				k= name.length();
				if(k<=18){
					number=0;

				}

			}while(number !=0);
			number=1;

		}


		System.out.println( "What is the age of the stundent??");
		age= sc.nextInt();
		sc.nextLine();

		holder=age+"";
		k=holder.length();
		if (k>18){
			do{
				
				System.out.println("The age is to long, write the age again.");
				age= sc.nextInt();
				sc.nextLine();
				
				holder=age+"";
				k= holder.length();
				if(k<=18){
					number=0;
				}

			}while(number !=0);
			number=1;

		}

		System.out.println( "What is the id of the student?");
		id= sc.next();
		sc.nextLine();

		
		k= id.length();
		if (k>18){
			do{
				

				System.out.println("The id is to long, write the id again.");
				id= sc.next();
				sc.nextLine();
				
				k= id.length();
				if(k<=18){
					number=0;

				}

			}while(number !=0);
			number=1;

		}

		System.out.println("Input the grades the student got\n\n1)Matematicas Aplicadas: \n");
		for (int counter=0; counter<3; counter++){
			System.out.println("Input the grade the student got int the exam number " + (counter+1));
			grades[0][counter] =sc.nextDouble();
		}
		System.out.println("\n\n2)Apo 1: \n");
		for (int counter=0; counter<3; counter++){
			System.out.println("Input the grade the student got int the exam number " + (counter+1));
			grades[1][counter] =sc.nextDouble();
		}
		System.out.println("\n\n2)ingenieria de Software: \n");
		for (int counter=0; counter<3; counter++){
			System.out.println("Input the grade the student got int the exam number " + (counter+1));
			grades[2][counter] =sc.nextDouble();
		}
		for (int counter=0; counter<3; counter++){
			avgGrades[counter] = (grades[counter][0] +grades[counter][1] + grades[counter][2])/3;
		}

		average = ((avgGrades[0]*4)+(avgGrades[1]*3)+(avgGrades[2]*2))/9;
		System.out.println(average);

		calculator.addStudent(name, age, average, id, grades);
	}

	public void DidStudentAprove(){
		String id = "";
		int[] student = null;
		double average = 0;
		System.out.println("input the id of the student:");
		id = sc.next();
		sc.nextLine();
		student = calculator.FindStudentById(id);
		if (student != null){
			average = (calculator.getAverage(student[0], student[1]));
			if (average<=3.5){
				System.out.println("The student falied the semester");
			}
			else{
				System.out.println("The student passed the semester");
			}
		}

	}

	public void printGrades(){
		String id = "";
		int[] student = null;
		System.out.println("input the id of the student:");
		id = sc.next();
		sc.nextLine();
		student = calculator.FindStudentById(id);
		if (student != null){
			System.out.println(calculator.PrintGrades(student[0], student[1]));
		}
	}

}
