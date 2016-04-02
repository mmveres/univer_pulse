package prjVehicle;

public abstract class CVehicle {
private String name;
private float price;
private int year;
private float speed;


CVehicle(String name){
	this.name=name;
	this.price=0;
	this.year=1900;
	this.speed=0;
}
CVehicle(String name, float price, int year, float speed){
	this.name=name;
	this.price=price;
	this.year=year;
	this.speed=speed;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public float getSpeed() {
	return speed;
}
public void setSpeed(float speed) {
	this.speed = speed;
}

@Override
public String toString() {
	return "CVehicle [name=" + name + ", price=" + price + ", year=" + year
			+ ", speed=" + speed + "]";
}
abstract void print();
}
