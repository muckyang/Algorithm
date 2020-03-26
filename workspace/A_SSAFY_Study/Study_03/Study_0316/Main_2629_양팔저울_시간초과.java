package Study_0316;

import java.util.Scanner;

public class Main_2629_양팔저울_시간초과 {
	static int N, K;
	static int[] choo;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		choo = new int[N];
		for (int i = 0; i < N; i++) {
			choo[i] = sc.nextInt();
		}
		K = sc.nextInt();
		v = new boolean[40001];
		combi(0, 0, 0);
		
		for (int i = 0; i < K; i++) {
			int gooseul = sc.nextInt();
			if (v[gooseul])
				System.out.print("Y ");
			else
				System.out.print("N ");
		}
	}

	private static void combi(int start, int count, int sum) {
		if (count > 0) {
			v[sum] = true;
		}
		if (count == N)
			return;
		for (int i = start; i < N; i++) {
			count++;
			if (sum - choo[i] > 0)
				combi(i + 1, count, sum - choo[i]);

			combi(i + 1, count, sum + choo[i]);

		}
	}
}
