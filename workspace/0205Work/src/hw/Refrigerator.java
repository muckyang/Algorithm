package hw;

public class Refrigerator {
	private int number;
	private String name;
	private int price;
	private int count;
	private int volume;
	
	public Refrigerator(int number, String name, int price, int count, int volume) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.count = count;
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "Refrigerator [number=" + number + ", name=" + name + ", price=" + price + ", count=" + count
				+ ", volume=" + volume + "]";
	}
}
