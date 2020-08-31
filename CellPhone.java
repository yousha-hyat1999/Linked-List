import java.util.Scanner;

public class CellPhone implements Cloneable2 {

	private long serialNum;
	private double price;
	private int year;
	private String brand;

	public CellPhone(long serialNum, double price, int year, String brand) {
		this.serialNum = serialNum;
		this.price = price;
		this.year = year;
		this.brand = brand;
	}

	public CellPhone(CellPhone cp, long value) {
		serialNum = value;
		price = cp.price;
		year = cp.year;
		brand = cp.brand;
	}

	public CellPhone clone() {
		Scanner kb = new Scanner(System.in);

		System.out.println("Please enter your serial number: ");
		long newSerialNum = kb.nextLong();

		if (this.serialNum == newSerialNum) {
			System.out.println(
					"The number that you entered is the same as the previous you entered, please enter a new one: ");
			clone();
		}

		return new CellPhone(this, newSerialNum);
	}

	public String toString() {
		return "[Serial Number=" + serialNum + ", price=" + price + ", year=" + year + ", brand=" + brand + "]";
	}

	public boolean equals(Object x) {
		if (x == null || x.getClass() != this.getClass() || this == null)
			return false;
		else {
			CellPhone c = (CellPhone) x;
			if (this.price == price && this.year == c.year || this.brand == c.brand)
				return true;
			else
				return false;
		}

	}

	public long getSerialNum() {
		return serialNum;
	}

	public double getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}

	public String getBrand() {
		return brand;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
