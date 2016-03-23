package prjSocketObject;

import java.io.Serializable;

public class Calc implements Serializable {
int oper;
int value1;
int value2;
int res;
public Calc(int oper, int value1, int value2) {
	super();
	this.oper = oper;
	this.value1 = value1;
	this.value2 = value2;
}
@Override
public String toString() {
	return "Calc [oper=" + oper + ", value1=" + value1 + ", value2=" + value2
			+ ", res=" + res + "]";
}

}
