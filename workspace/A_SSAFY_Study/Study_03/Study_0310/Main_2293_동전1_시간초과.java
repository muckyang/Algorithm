package Study_0310;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2293_동전1_시간초과 {
	static int N, K;
	static int[] list;
	static int[] counts;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		list = new int[N];
		counts = new int [K];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		solve(0,K);
		System.out.println(counts[0]);
	}

	private static void solve(int start, int number) {
		for (int i = start; i < N; i++) {
			int su = number - list[i];
			if (su >= 0) {
				counts[su]++;
				solve(i, su);
			}
		}

	}
}
