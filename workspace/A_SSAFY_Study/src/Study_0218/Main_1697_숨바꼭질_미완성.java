package Study_0218;

import java.util.Scanner;

public class Main_1697_숨바꼭질_미완성 {
	static int N, K;
	static int[] list;
	static int minc;

	public static void func(int n, int k, int c) {
		if (minc < c)
			return;
		if (n == k) {
			minc = c;
			return;
		}

		if (n < k) {
			func(n * 2, k, c + 1);
		}
		func(n + 1, k, c + 1);
		func(n - 1, k, c + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		minc = Integer.MAX_VALUE;
		func(N, K, 0);
		System.out.println(minc);
	}
}
