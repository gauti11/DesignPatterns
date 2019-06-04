package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {
	
	public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBool, int myOtherInt, long myLongInt) {
		super();
		this.myInt = myInt;
		this.myLong = myLong;
		this.myString = myString;
		this.myBool = myBool;
		this.myOtherInt = myOtherInt;
		this.myLongInt = myLongInt;
	}

	public MyAllTypesFirst() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public long getMyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public boolean isMyBool() {
		return myBool;
	}
	public void setMyBool(boolean myBool) {
		this.myBool = myBool;
	}
	public int getMyOtherInt() {
		return myOtherInt;
	}
	public void setMyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}
	public long getMyLongInt() {
		return myLongInt;
	}
	public void setMyLongInt(long myLongInt) {
		this.myLongInt = myLongInt;
	}
	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	private int myOtherInt;
	private long myLongInt;
	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myLong=" + myLong + ", myString=" + myString + ", myBool="
				+ myBool + ", myOtherInt=" + myOtherInt + ", myLongInt=" + myLongInt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (myBool ? 1231 : 1237);
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result + (int) (myLongInt ^ (myLongInt >>> 32));
		result = prime * result + myOtherInt;
		result = prime * result + ((myString == null) ? 0 : myString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		MyAllTypesFirst var = (MyAllTypesFirst) o;
		if (myInt != var.myInt)
			return false;
		if (myOtherInt != var.myOtherInt)
			return false;
		if (myLongInt != var.myLongInt)
			return false;
		if (myLong != var.myLong) return false;
		if (myBool != var.myBool) return false;
		return myString.equals(var.myString);

	}



}
