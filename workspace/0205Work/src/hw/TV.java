package hw;

public class TV {

	private int number;
	private String name;
	private int price;
	private int count;
	private int inch;
	private String displayType;
	@Override
	public String toString() {
		return "TV [number=" + number + ", name=" + name + ", price=" + price + ", count=" + count + ", inch=" + inch
				+ ", displayType=" + displayType + "]";
	}
	
	public TV(int number, String name, int price, int count, int inch, String displayType) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.count = count;
		this.inch = inch;
		this.displayType = displayType;
	}

}
