package ws;

public class BookTest {
	public static void main(String[] args) {
		Book book1 = new Book("21424", "Java Pro", "김하나" , "Jean.kr", 15000 , "Java 기본 문법" );
		Book book2 = new Book("35355", "분석설계", "소나무" , "Jean.kr", 30000 , "SW 모델링" );
		Magazine magazine = new Magazine("35555", "Java World", "편집부" , "Java.com", 7000 ,2018,2, "첫걸음"); 
	
	System.out.println("*************도서목록*************");
	System.out.println(book1.toString());
	System.out.println(book2.toString());
	System.out.println(magazine.toString());
	}
}
