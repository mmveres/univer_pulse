package prjStudent;

import java.util.Scanner;

public class Student {
String fio;
int numGroup;
int []marks;
Student (String fio, int numGroup, int numMarks){
	this.fio=fio;
	this.numGroup=numGroup;
	marks=new int[numMarks];
}
Student(){
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter parametrs of student");
	System.out.println("Enter fio");
	this.fio=sc.nextLine();
	System.out.println("Enter number group");
	while(!sc.hasNextInt()){
		System.out.println("Enter number group int value");
	    sc.nextLine();	
	}
	this.numGroup=sc.nextInt();
	System.out.println("Enter numbers of marks");
	marks=new int[sc.nextInt()];
//	if (sc!=null)sc.close();
}
float averageMarks(){
	float sum=0;
	for (int i = 0; i < marks.length; i++) {
		sum=sum+marks[i];
	}
	return sum/marks.length;
}
/**
 * this method fill marks in array marks
 * for Student from console
 */
void setMarksInSesiyaFromConsole(){
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter marks for student: "+this.fio);
	for (int i = 0; i < marks.length; i++) {
		System.out.println("mark "+i);
		marks[i]=sc.nextInt();
	}
//	if (sc!=null)sc.close();
}
void print(){
    System.out.println("fio="+this.fio+", num="+this.numGroup+
    		", numMarks="+this.marks.length);
    for (int i = 0; i < marks.length; i++) {
		System.out.print(marks[i]+", ");
	}
    System.out.println("\n-------");
}
}
