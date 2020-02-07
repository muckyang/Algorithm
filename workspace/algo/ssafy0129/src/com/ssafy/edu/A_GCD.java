package com.ssafy.edu;

public class A_GCD {

	public static int GCD(int x, int y) {
		int result = 0;
		
		if(x == y) {
			return x;
		}
		else if( x > y ){
			return GCD(x-y,y);
		}else {
			return GCD(x,y-x);
		}
		
	}
	
	
	public static int LCM(int x, int y) {
		return x * y/GCD(x,y);
	}
	
	public static void main(String[] args) {
		int k = GCD(50,30);
		System.out.println("GCD : " + k);
		System.out.println("LCM : " + LCM(50,30));
	}

}
