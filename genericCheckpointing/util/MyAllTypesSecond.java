	package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject
{

	public MyAllTypesSecond() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public double getMyDoubleT() {
		return myDoubleT;
	}
	public void setMyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	public float getMyFloaT() {
		return myFloaT;
	}
	public void setMyFloaT(float myFloaT) {
		this.myFloaT = myFloaT;
	}
	public short getMyShortT() {
		return myShortT;
	}
	public void setMyShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	public char getMyCharT() {
		return myCharT;
	}
	public void setMyCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT = myOtherDoubleT;
	}
	private double myDoubleT;
	private float myFloaT;
	private short myShortT;
	private char myCharT;
	public MyAllTypesSecond(double myDoubleT, float myFloaT, short myShortT, char myCharT, double myOtherDoubleT) {
		super();
		this.myDoubleT = myDoubleT;
		this.myFloaT = myFloaT;
		this.myShortT = myShortT;
		this.myCharT = myCharT;
		this.myOtherDoubleT = myOtherDoubleT;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloaT);
		temp = Double.doubleToLongBits(myOtherDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myShortT;
		return result;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MyAllTypesSecond var1 = (MyAllTypesSecond) o;

		if(myDoubleT<10)
			setMyDoubleT(0);
		if(myFloaT<10)
			setMyFloaT(0);
		if(myOtherDoubleT<10)
			setMyOtherDoubleT(0);
		if (myDoubleT != var1.myDoubleT) 
			return false;
		if (myFloaT != var1.myFloaT) 
			return false;
		if (myShortT != var1.myShortT) 
			return false;
		if (myCharT != var1.myCharT) 
			return false;
		if (myOtherDoubleT != var1.myOtherDoubleT) 
			return false;
		return true;
	}
	
	
	
	private double myOtherDoubleT;
	@Override
	public String toString() {
		return "MyAllTypesSecond [myDoubleT=" + myDoubleT + ", myFloaT=" + myFloaT + ", myShortT=" + myShortT
				+ ", myCharT=" + myCharT + ", myOtherDoubleT=" + myOtherDoubleT + "]";
	}
	
	
}
