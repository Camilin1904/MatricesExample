package model;

public class Student {
    private String name;
    private int age;
    private double average;
    private String id;
    private NoteSubject[][] notes;

    public Student(String name, int age, double average, String id, NoteSubject[][] notes){
        this.name = name;
        this.age = age;
        this.average = average;
        this.id = id;
        this.notes = notes;
    }
    public int getAge() {
        return age;
    }
    public double getAverage() {
        return average;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String PrintGrades(){
		String message = "                         Matematicas Aplicadas   APO 1                   Ingenieria de Software \n ______________________  ______________________  ______________________  ______________________ \n", dataHolder = "";
		int lengthDifference = 0; 
		for (int counter=0; counter<3&&dataHolder!=null; counter++){
			for (int counter2=0; counter2<4&&dataHolder!=null; counter2++){
                if (counter2==0){
                    message += "|Parcial " + (counter+1) + "             |";
                }
                else{
                    dataHolder = notes[counter2-1][counter].getValueNote() + "";
                    lengthDifference = Math.abs(((dataHolder).length() - 22));
                    if (lengthDifference>0&&dataHolder!=null){
                        for (int counter3 = 0; counter3<lengthDifference; counter3++){
                            dataHolder += " ";
                        }
                    }
                    message += "|" + dataHolder + "|";
                    
                }
			}
			if (dataHolder!=null){
				message += "\n ----------------------  ----------------------  ----------------------  ---------------------- \n";
			}
		}
		return message;
	}
}
