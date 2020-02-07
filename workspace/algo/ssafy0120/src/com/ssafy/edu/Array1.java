package com.ssafy.edu;

public class Array1 {
	public static void main(String[] args) {
		int [] a = {1,2,3};
		int [] b = new int [] {1,2,3};
		// a= {1,2}; // 정적배열에 재할당하면 에러
		b = new int[] {1,2,3,4,5,6}; // new int[] {배열내용} 으로 재할당 가능
		System.out.println(a.length);
		System.out.println(b.length);
		
		int [] c = a; // 얕은 복사 
		c[1] = -4; //a의
		System.out.println("c[1] : " + c[1]);
		System.out.println("a[1] : " + a[1]);
		
		int [] d = new int[a.length];
		System.arraycopy(a,0,d,0,a.length); //a의 0 부터 d의 0에 a.length길이만큼 복사해줌
		d[0] = -5;
		System.out.println("d[0] : " + d[0]);
		System.out.println("a[0] :  " + a[0]);

		
	
	}
}
