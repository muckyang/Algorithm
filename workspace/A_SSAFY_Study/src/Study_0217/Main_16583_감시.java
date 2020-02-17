package Study_0217;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16583_감시 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] list;
	static int camerac;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> que;
	static int min;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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
					que.add(new Point(i, j));
				} else if (matrix[i][j] != 0 && matrix[i][j] > 5) {
					camerac++;
				}
			}
		}
		list = new int[camerac];
		System.out.println(camerac);

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
				if(mat[i][j] == 0)
					count++;
			}
		}
		if(min == Integer.MAX_VALUE) {
			min = count;
		}
		System.out.println(min);
	}

	private static void allcheck(int[][] mat, int c) {
		
		if (c == camerac) {
			for (int k = 0; k < c; k++) {
				boolean[] ban = new boolean[4];
				if(que.isEmpty())
					break;
				Point p = que.poll();
				if (mat[p.x][p.y] == 4) {
					ban[list[k]] = true;
					func(mat, p.x, p.y, ban);
				} else if (mat[p.x][p.y] == 2) {
					if(2 <= list[k] )
						continue;
					ban[list[k]] = true;
					ban[list[k]+2] = true;
					func(mat, p.x, p.y, ban);
				} else if (mat[p.x][p.y] == 3) {
					ban[list[k]] = true;
					if (list[k] == 3)
						ban[0] = true;
					else
						ban[list[k]] = true;
					func(mat, p.x, p.y, ban);
				} else if (mat[p.x][p.y] == 1) {
					for (int d = 0; d < 4; d++) {
						if (list[k] == d)
							continue;
						ban[d] = true;
					}
					func(mat, p.x, p.y, ban);
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mat[i][j] == 0)
						cnt++;
				}
			}
			System.out.println(cnt);
			if (min > cnt)
				min = cnt;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mat[i][j] > 0 && mat[i][j] < 5 && !visited[i][j]) {
						que.add(new Point(i, j));
						visited[i][j] = true;
						for (int d = 0; d < 4; d++) {
							list[c] = d;
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
