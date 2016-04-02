package prjStudent;

public class Group {
	Student []  groupStudent;
public Group(int countStud) {
	groupStudent=new Student[countStud];
	
}
void fillGroup(){
	 for (int i = 0; i < groupStudent.length; i++) {
   	  groupStudent[i]=new Student();    	  
	}
}
void fillMarksInSesiya(){
	 for (int i = 0; i < groupStudent.length; i++) {    	  
   	  groupStudent[i].setMarksInSesiyaFromConsole();
	} 
}
void printStudentsWithStipendiya(float ballMark){
	int countStudAverageMarkGreaterThenBallMrk=0;
    for (int i = 0; i < groupStudent.length; i++) {
  	  if(groupStudent[i].averageMarks()>ballMark){
  	  groupStudent[i].print();     	 
  	  countStudAverageMarkGreaterThenBallMrk++;
  	  }    	  
	}
    if(countStudAverageMarkGreaterThenBallMrk==0)
  	  System.out.println("Stipendiantov Net");
}
}
