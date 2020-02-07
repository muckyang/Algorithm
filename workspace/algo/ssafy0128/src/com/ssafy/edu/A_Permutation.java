package com.ssafy.edu;

import java.util.Arrays;

//순열
public class A_Permutation {
	static int flag_;
	static int [] num;
	static int m ; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num = new int [2];
		m =0;		
		flag_ = 0;
		permutation(3, 2, 0, 0);
		System.out.println("count : " + m);
	}
	
	public static void permutation(int n, int r, int flag, int count)	 {
		if(count == r) {
			System.out.println(Arrays.toString(num));
			m++;
			return;
		}
		for(int i = 0; i < n; i++) {
			if( (flag & 1 << i) != 0) {
				continue;
			}
			
			if( (flag & 1 << i) == 0) { // firstrun > flag -> 0 & 1 << 0, 0 & 1 << 1, 0 & 1 << 2 
				num[count]  = i + 1;
				permutation(n, r, flag | 1 << i ,count + 1);
			}
		}
	}
}
