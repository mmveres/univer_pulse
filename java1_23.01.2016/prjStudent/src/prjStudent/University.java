package prjStudent;

public class University {

	public static void main(String[] args) {
		// TODO дописать группу студентов
	    Group javaSaturday=new Group(3);
     //create group student         
        javaSaturday.fillGroup();
      // set marks for all students in group
        javaSaturday.fillMarksInSesiya(); 
      //print information about all students in group 
        javaSaturday.printStudentsWithStipendiya(4);
   }

}
