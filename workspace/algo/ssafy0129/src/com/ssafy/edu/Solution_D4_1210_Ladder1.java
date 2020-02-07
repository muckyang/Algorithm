package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {
	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, 1, 0 };
	static int[][] Ladder = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int rx = 0, ry = 0;
		for (int test_case = 1; test_case < T; test_case++) {
			
			for (int y = 0; y < 100; y++) {
				for (int x = 0; x < 100; x++) {
					Ladder[y][x] = sc.nextInt();
					if (Ladder[y][x] == 2) {
						rx = x;
						ry = y - 1;
					}
				}
			}

			int d = 2;
			while (ry != 0) {
				if (rx - 1 > 0 && Ladder[ry][rx - 1] > 0 && d != 1) {
					d = 0;
				}
				if (rx + 1 < 100 && Ladder[ry][rx + 1] > 0 && d != 0) {
					d = 1;
				}
				int ty = ry + dy[d];
				int tx = rx + dx[d];
				
				if (tx >= 100 || tx <= 0 || ty >= 100 || ty <= 0 | Ladder[ty][tx] == 0) { // 길이 아니거나 벽을 넘어감
					// 원위치 시켜줌
					ty = ry - dy[d];
					tx = rx - dx[d];
					d = 2;
					// d=2 방향으로 증가시킴
					ty = ry + dy[d];
					tx = rx + dx[d];

				}
			}
			System.out.println("#" + test_case + " " + rx);
		}
	}
}
