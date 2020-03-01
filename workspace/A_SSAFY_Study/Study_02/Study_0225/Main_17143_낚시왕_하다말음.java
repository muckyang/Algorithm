package Study_0225;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_17143_낚시왕_하다말음 {
	static int N, M, S;
	static boolean[][] matrix;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] sharkx;
	static int[] sharky;
	static int[] sharks;
	static int[] sharkd;
	static int[] sharkz;

	private static class Shark {
		int x;
		int y;
		int speed;
		int d;
		int size;

		public Shark(int x, int y, int speed, int d, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.d = d;
			this.size = size;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.nextInt();
		matrix = new boolean[N][M];
		sharkx = new int[S];
		sharky = new int[S];
		sharks = new int[S];
		sharkd = new int[S];
		sharkz = new int[S];
		for (int i = 0; i < S; i++) {
			sharkx[i] = sc.nextInt() - 1;
			sharky[i] = sc.nextInt() - 1;
			matrix[sharkx[i]][sharky[i]] = true;
			sharks[i] = sc.nextInt();
			sharkd[i] = sc.nextInt();
			sharkz[i] = sc.nextInt();
		}
		int sums = 0;
		for (int k = 0; k < M; k++) {
			int s = 0;
			int kill = -1;
			for (int j = 0; j < S; j++) {
				if (sharky[j] == k) {
					if (kill == -1) {
						s = sharkz[j];
						kill = j;
					} else if (kill != -1 && sharkx[j] < sharkx[kill]) {
						s = sharkz[j];
						kill = j;
					}
				}
			}
			sums += s;
			if (kill != -1) {
				matrix[sharkx[kill]][sharky[kill]] = false;
				sharkx[kill] = -1;
				sharky[kill] = -1;
				sharks[kill] = -1;
				sharkd[kill] = -1;
				sharkz[kill] = -1;
			}
			// 낚시하기 성공 (1,2 )

			boolean[][] mat = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (matrix[i][j]) {
						move(i, j, mat);
					}

				}
			}
			for (int i = 0; i < N; i++)
				System.arraycopy(mat[i], 0, matrix[i], 0, mat[i].length);
			// 상어 이동 시퀀스

		}
		System.out.println(sums);
	}

	private static void move(int x, int y, boolean[][] mat) {
		
		

	}
}
