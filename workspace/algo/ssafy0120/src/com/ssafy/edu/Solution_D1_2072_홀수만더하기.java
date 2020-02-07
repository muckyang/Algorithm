package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D1_2072_홀수만더하기{
	private static Scanner sc;
	public static void main(String args[]) {
		int n = 10;
		int[] list = new int[n];
		sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int sum = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < n; i++) {
				list[i] = sc.nextInt();
				if (list[i] % 2 == 1)
					sum += list[i];

			}
			System.out.printf("#%d %d\n", test_case, sum);
			sum = 0;
		}
	}
}
