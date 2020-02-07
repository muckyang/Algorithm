package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D1_2071_평균구하기{
	static int iT;
	static int n = 10;
	static int [] num;
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);  
		iT=sc.nextInt();
	
		for(int i = 1; i <= iT; i++){
			num = new int[n];
			for(int j =0; j< n;j++) {
				num[j] = sc.nextInt();
			}
			int s = 0;
			for(int j = 0; j< n;j++) {
				s= s+num[j];
			}
			double ds = 0.0;
			ds = (double)s/n;
			ds = Math.round(ds);
			System.out.printf("#%d %.0f\n",i,ds);
			
		}
	}

}
