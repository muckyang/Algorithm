package Study_0215;

import java.util.Scanner;

public class Main_17471_게리맨더링 {
	static int N;
	static int[] pop;
	static int[][] link;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		pop = new int[N];
		link = new int[N][N];

		for (int i = 0; i < N; i++) {
			pop[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int c = sc.nextInt();
			for (int j = 0; j < c; j++) {
				int k = sc.nextInt();
				link[c][k] = 1;
				link[k][c] = 1;

			}
		}

	}
}
