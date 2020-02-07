package com.ssafy.edu;
//계단 오르는 방법의 수
public class A_Fibonachi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibo(7));
		System.out.println(1.0 * fibo(25) / fibo(26));
		System.out.println(1.0 * fibo(27) / fibo(28));
	}
	
	public static int fibo(int n) { // n > r
		if (n == 1) 
			return 1;
		else if(n == 2)
			return 2;
		else 
			return fibo(n-1) + fibo(n-2);
		

	}
}
