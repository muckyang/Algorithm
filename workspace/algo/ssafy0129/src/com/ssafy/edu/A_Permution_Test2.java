package com.ssafy.edu;

public class A_Permution_Test2 {
	static int N = 5;
	static int R = 3;
	static char [] c; 
	public static void nPr(int flag , int count) {
		if(count == R) {
			System.out.println(String.valueOf(c)); //char형 배열 String으로 변환
			return;
		}
		for (int i = 0; i < N; i++) {
			if ( (flag & 1 << i) != 0) {
				continue;
			}
			if ( (flag & 1 << i) == 0) {
				c[count] = (char)('A' + i);
				nPr((flag | 1 << i) , count + 1);
			}
			
		}
	}
	public static void main(String[] args) {
		c= new char[R];
		nPr(0,0);
	}
}
