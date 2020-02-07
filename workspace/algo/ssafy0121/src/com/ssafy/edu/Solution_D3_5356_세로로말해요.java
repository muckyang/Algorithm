package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5356_세로로말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] S_list = new String[5];
		
		char [][] C_list = new char[5][15];
		
		StringBuffer result=new StringBuffer();
		int T;
		T = sc.nextInt();
		for(int test_case =1 ; test_case <= T;test_case++) {
		
			for(int i = 0 ; i< 5; i++) {
				Arrays.fill(C_list[i],' ');
				S_list[i]=sc.next();
				C_list[i]=S_list[i].toCharArray();
			}
				for(int j = 0; j < 15;j++) {
					for(int i = 0; i < 5;i++) {
						if(C_list[i][j] != ' ') {
							result.append(C_list[i][j]);
						}
					}
				}
			System.out.println("#" + test_case +" "+ result);
		}
	}

}

/*
 * 
2
ABCDE
abcde
01234
FGHIJ
fghij
AABCDD
afzz
09121
a8EWg6
P5h3kx

 * */
