package prjVehicle;

public class WorldOfVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      CCar bmw=new CCar("i3", "auto", 1, 2000, 3);
	  bmw.getName();
	  bmw.getMarka();
	//  CVehicle veh=new CVehicle("name");
	//  veh.print();
	  CVehicle [] massOfVeh= new CVehicle[3];
	  massOfVeh[0]=bmw;
	  massOfVeh[1]=new CPlane("AN-24");
	  massOfVeh[2]=new Ship("titanic");
	  for (int i = 0; i < massOfVeh.length; i++) {
	//	massOfVeh[i].print();
		System.out.println(massOfVeh[i]);
	}
	}

}
