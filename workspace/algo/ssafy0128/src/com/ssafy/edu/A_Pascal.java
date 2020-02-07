package com.ssafy.edu;
//파스칼의 삼각형
public class A_Pascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pascal(15 ,3));
	}
	
	public static int pascal(int n, int r) { // n > r
		if(r==0 || r==n)
			return 1;
		else
			return pascal(n-1,r-1) + pascal(n-1,r);
	}
}
