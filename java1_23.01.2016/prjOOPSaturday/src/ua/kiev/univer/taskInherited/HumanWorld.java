package ua.kiev.univer.taskInherited;
class Human{
	String name;
	int age;
	void sleep(){System.out.println("Human sleeping...");}
}
class Student extends Human{	
	int numGroup;
	void study(){System.out.println("Student study...");}
	@Override
	void sleep(){System.out.println("Student sleeping on pair...");}
}
class Doctor extends Human{
	int licenseID;
}
class Fighter extends Human{
	int hp;
}
public class HumanWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student st1 = new Student();
        ((Student)st1).sleep();
        Doctor doc1 = new Doctor();
        Fighter fighter1= new Fighter();
       
        Human [] peoples=new Human[3];
        peoples[0]=st1;
        peoples[1]=doc1;
        peoples[2]=fighter1;
        
    //    st1.study();
	}

}
