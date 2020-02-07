package com.ssafy.edu;

import java.util.Scanner;

public class Jungol_1175_주사위던지기2 {
	static int[] num;
	static int sum;

	public static void func1(int N, int R, int S, int count) {

		if (R == count) {
			if (S == sum) {
				for (int s : num)
					System.out.print(s + " ");
				System.out.println();
			} else
				return;
		} else {
			for (int i = 1; i <= N; i++) {
				num[count] = i;
				func1(N, R, S + i, count + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M; // 2<= N <=5
		N = sc.nextInt();
		sum = sc.nextInt();
		num = new int[N];
		func1(6, N, 0, 0);

	}

}
