package ua.kiev.univer.taskOOP;

import java.util.Scanner;

import ua.kiev.univer.taskOOP.Currency.USD;
import ua.kiev.univer.taskOOP.Product.*;

public class SuperMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   USD.value=25.00;	
       Vegetable potatoes=new Vegetable();
       Meat pork = new Meat();
       
       System.out.println(Fruit.id);
       
       Fruit apple=new Fruit("Golden", 16, 20);
       Fruit apple2=new Fruit("Gorec", 20, 20);
       System.out.println("id= "+Fruit.id+" personalId= "+apple.personalID);
       System.out.println("id= "+Fruit.id+" personalId= "+apple2.personalID);
       
       Fruit [] masOfFruit= new Fruit[3];
       masOfFruit[0]=apple;
       masOfFruit[1]=apple2;
       masOfFruit[2]=new Fruit("Red apple", 15, 40);      
      ; 	   
      Scanner sc= new Scanner(System.in);
      System.out.println("Enter fruits ");
      for (int i = 0; i < masOfFruit.length; i++) {
    	System.out.println("Enter fruit index ="+i+" of "+masOfFruit.length);
		System.out.println("Enter name");
		String curName=sc.next();
		System.out.println("enter price");
		double curPrice=sc.nextDouble();
		System.out.println("enter weight");
		double curWeight=sc.nextDouble();
		masOfFruit[i]=new Fruit(curName, curPrice, curWeight);
	}
       for (int i = 0; i < masOfFruit.length; i++) {
    	//   if (masOfFruit[i].getName().charAt(0)=='G')
		System.out.println(masOfFruit[i].getName());   	   
      
	}
       
	}

}
