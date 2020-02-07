package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_2007_패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		String S;
		int c;
		int s_len;
		int length_max;
		String subS;
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			c = 0;
			s_len = 30;
			length_max = 10;
			S = sc.next();
			
			for (int i = 1; i < 11; i++) {
				subS = S.replaceAll(S.substring(0,i), "");// 삭제 했을때 길이가 0이되면 마디.
				if(subS.length() < s_len) {
					s_len = subS.length();
					length_max = i;
				}
			}
			
			System.out.println("#"+ t + " " + length_max);

		}
		
	}
}
