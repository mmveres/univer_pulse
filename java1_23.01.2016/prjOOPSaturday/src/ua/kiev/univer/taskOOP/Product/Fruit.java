package ua.kiev.univer.taskOOP.Product;

import ua.kiev.univer.taskOOP.Currency.USD;

public class Fruit {
String name;
double price;
double weight;
static public int id=0;
public int personalID=id;
public Fruit(String name, double price, double weight) {
	this.name=name;
	this.price=price/USD.value;
	this.weight=weight;
	id++;
	personalID=id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price*USD.value;
}
public void setPrice(double price) {
	this.price = price/USD.value;
}
}
