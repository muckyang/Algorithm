package ws;
public class Magazine {

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private int year;
	private int month;
	private String desc;
	
	public Magazine(String isbn, String title, String author, String publisher, int price, int year, int month,
			String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.year = year;
		this.month = month;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return isbn + "\t| "  + title + "\t| "  + author + "\t| "  + publisher
				+ "\t| " + price + "\t| "   + desc + "\t\t| "+year +"."+month ;
	}
	
	
	
}
