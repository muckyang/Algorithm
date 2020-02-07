package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D1_2070_큰놈작은놈같은놈 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		
		int f, s;
		for (int test_case = 1; test_case <= T; test_case++) {
			f = sc.nextInt();
			s = sc.nextInt();
			if (f > s)
				System.out.printf("#%d %c\n", test_case, '>');
			else if (f < s)
				System.out.printf("#%d %c\n", test_case, '<');
			else
				System.out.printf("#%d %c\n", test_case, '=');
		}
	}
}
