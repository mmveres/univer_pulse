package prjVehicle;

public class CCar extends CVehicle{
private String marka;
	public CCar(){
	super("Anonim");	
	}

	public CCar(String marka,String name, float price, int year, float speed) {
		super(name, price, year, speed);
		this.marka=marka;
	}
    public CCar(int year){
    	super("mmm", 0, year, 0);
    }
    
	public CCar(String name) {
		super(name);		
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	@Override
	void print() {
		System.out.println(this);
		
	}
    
	

}
