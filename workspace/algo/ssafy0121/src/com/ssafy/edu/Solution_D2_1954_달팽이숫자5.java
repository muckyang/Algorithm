package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자5 {
	static int T;
	static int N;
	static int[][] snail;
	// static int [] dy = {0,1,0,-1};
	// static int [] dx = {1,0,-1,0};
	// reverse
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			snail = new int[N][N];

			int d = 0;
			int y = 0;
			int x = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					snail[y][x] = i * N + j + 1;

					if (!(x + dx[d] < N && y + dy[d] < N && x + dx[d] >= 0 && y + dy[d] >= 0
							&& snail[y + dy[d]][x + dx[d]] == 0)) {
						if (d == 0)
							d = 1;
						else if (d == 1)
							d = 2;
						else if (d == 2)
							d = 3;
						else if (d == 3)
							d = 0;
					}
					x += dx[d];
					y += dy[d];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
