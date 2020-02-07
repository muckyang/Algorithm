package com.ssafy.edu;

public class A_Combination_Test2 {

	static int N = 5; 
	static int R = 3;
	static char [] c;
	static int cnt;
	public static void nCr (int start, int count) {
		if(count == R) {
			cnt++;
			System.out.println(String.valueOf(c)); // 배열을 스트링으로 변환
			return;
		}
		
		for (int i = start; i < N; i++) {// i = start 대신 i = 1 로 하면 뒤로도 감
			c[count] = (char)('A' + i);// 65 + i
			nCr(i + 1 , count + 1);
			//nCr(i,count +1); //i + 1 대신 i 하면 중복해서 출력된다.
		}
	}
	
	
	public static void main(String[] args) {
		cnt = 0;
		c = new char[R];
		nCr(0,0);
		System.out.println(cnt);
	}
	
}
