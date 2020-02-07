package com.ssafy.edu;

public class A_Factorial {

	
	public static long fact(long n) {
		if( n == 1)
			return 1L;
		else {
			return fact(n-1) * n ;
		}
	}
	public static void main(String[] args) {

		System.out.println(fact(12));
		System.out.println(fact(20));
		System.out.println(fact(19));//터짐
	}

}
