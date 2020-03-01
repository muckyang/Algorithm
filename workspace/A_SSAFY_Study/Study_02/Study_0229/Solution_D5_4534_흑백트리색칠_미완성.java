package Study_0229;

public class Solution_D5_4534_흑백트리색칠_미완성 {
	static int v;
	
	private static void func() {
		if(v!=100000) {
			v+=1;
			func();
		}
	}
	public static void main(String[] args) {
		v=0;
		func();
		System.out.println(v); 
		
	}
}
