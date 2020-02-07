package com.ssafy.edu;
import java.util.Scanner;
public class Solution_test1 {

	static int iT = 5;
	static int []a = new int[5];
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		// TODO Auto-generated method stub
		int [][] block = new int [100][100];
		int m = scann.nextInt();
		
		a=new int[m]; // 배열사이즈 초기화
		
		for (int i = 0 ; i< iT ; i++) {
			a[i] = scann.nextInt();
		}
		
		for(int i = 0; i< a.length ; i++) {
			System.out.print(a[i] + " ");		
		}
		
		System.out.println();
	}

}
