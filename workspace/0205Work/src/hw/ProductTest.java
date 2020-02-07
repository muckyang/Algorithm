package hw;

public class ProductTest {
	public static void main(String[] args) {
		TV tv1 = new TV(13245,"PAVV",300000,35,40,"A");
		TV tv2 = new TV(42445,"CHEC",450000,56,45,"B");
		Refrigerator rf1 = new Refrigerator(42355,"FEGH",900000,15,40);
		Refrigerator rf2 = new Refrigerator(42424,"ABCD",450000,35,60);
		
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(rf1.toString());
		System.out.println(rf2.toString());
		
	}
}
