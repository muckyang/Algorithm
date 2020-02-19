package Study_0217;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16583_감시 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int camerac;
	static int[][] lists;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> que;
	static int min;

	public static class Point {
		int x;
		int y;
		int d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		que = new LinkedList<Point>();
		matrix = new int[N][M];
		visited = new boolean[N][M];
		min = Integer.MAX_VALUE;
		camerac = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == 5) {
					que.add(new Point(i, j, -1));
				} else if (matrix[i][j] > 0 && matrix[i][j] < 5) {
					camerac++;
				}
			}
		}
//		System.out.println(camerac);
		lists = new int[3][camerac];

		int mat[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(matrix[i], 0, mat[i], 0, mat[i].length);
		}

		while (!que.isEmpty()) {
			Point p = que.poll();
			boolean[] b = new boolean[4];
			func(mat, p.x, p.y, b);
		}
		// 여기까진 맞음
		allcheck(mat, 0);
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == 0)
					count++;
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = count;
		}

		System.out.println(min);

	}

	private static void allcheck(int[][] mat, int c) {

		if (c == camerac) {
			int countmat[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(mat[i], 0, countmat[i], 0, mat[i].length);
			}
			for (int k = 0; k < c; k++) {

				boolean[] ban = new boolean[4];

				if (countmat[lists[0][k]][lists[1][k]] == 4) {
					ban[lists[2][k]] = true;
					func(countmat, lists[0][k], lists[1][k], ban);
				} else if (countmat[lists[0][k]][lists[1][k]] == 2) {
					if (2 > lists[2][k]) {
						ban[lists[2][k]] = true;
						ban[lists[2][k] + 2] = true;
					} else {
						ban[lists[2][k]] = true;
						ban[lists[2][k] - 2] = true;
					}
					func(countmat, lists[0][k], lists[1][k], ban);
				} else if (countmat[lists[0][k]][lists[1][k]] == 3) {
					ban[lists[2][k]] = true;
					if (lists[2][k] == 3)
						ban[0] = true;
					else
						ban[lists[2][k] + 1] = true;
					func(countmat, lists[0][k], lists[1][k], ban);
				} else if (countmat[lists[0][k]][lists[1][k]] == 1) {
//					System.out.println(lists[2][k]);	
					for (int d = 0; d < 4; d++) {
						if (lists[2][k] == d)
							continue;
						ban[d] = true;
					}

					func(countmat, lists[0][k], lists[1][k], ban);
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (countmat[i][j] == 0)
						cnt++;
				}
			}
//			System.out.println(cnt);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(countmat[i][j] + " ");
//				}
//				System.out.println();
//			}

			if (min > cnt)
				min = cnt;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mat[i][j] > 0 && mat[i][j] < 5 && !visited[i][j]) {

			
						lists[0][c] = i;
						lists[1][c] = j;
						visited[i][j] = true;
						for (int d = 0; d < 4; d++) {
							lists[2][c] = d;
							allcheck(mat, c + 1);
						}
						visited[i][j] = false;
					}
				}
			}

		}
	}

	private static void func(int[][] mat, int x, int y, boolean[] ban) {
		for (int d = 0; d < 4; d++) {
			if (!ban[d]) {
				killLine(mat, x, y, dx[d], dy[d]);
			}
		}
	}

	private static void killLine(int[][] mat, int x, int y, int dx, int dy) {
		while (true) {
			x += dx;
			y += dy;
			if (x < 0 || y < 0 || x >= N || y >= M || mat[x][y] > 0) {
				break;
			} else {
				mat[x][y] = -1;
			}
		}
	}
}
