package Study_0504;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2933_미네랄2 {

	static int R, C;
	static char[][] map;
	static int[][] nmap;
	static int N;
	static boolean[][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}
		N = sc.nextInt();
		int dir = 0;
		for (int n = 0; n < N; n++) {
			int row = sc.nextInt();
			remove(R - row, dir);
			nmap = new int[R][C];
			visit = new boolean[R][C];
			int cnt = -1;
			for (int i = R - 1; i >= 0; i--) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'x' && !visit[i][j]) {
						if (i == R - 1) {
							cnt = -1;
						}
						dfs(i, j, cnt);
						cnt += 2;
					}
				}
			}
			down();
			print();
			System.out.println();
			dir = dir == 0 ? 1 : 0;
		}

	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
				System.out.println();
			}
			System.out.println();
		}
	}

	static void dfs(int y, int x, int num) {
		visit[y][x] = true;
		nmap[y][x] = num;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx] || map[ny][nx] == '.')
				continue;
			dfs(ny, nx, num);
		}
	}

	static void down() {
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < C; j++) {
			int cnt = 0;
			for (int i = R - 1; i >= 0; i--) {
				if (nmap[i][j] == 1) {
					int ni = i;
					while (true) {
						ni++;
						if (ni >= R || nmap[ni][j] != 0)
							break;
						cnt++;
					}
				}
			}
			if (cnt != 0)
				min = Math.min(min, cnt);
		}
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(map[i], '.');
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (nmap[i][j] == -1)
					map[i][j] = 'x';
				else if (nmap[i][j] == 1)
					map[i + min][j] = 'x';
			}
		}
	}

	static void remove(int r, int dir) {
		if (dir == 0) {
			for (int i = 0; i < C; i++) {
				if (map[r][i] == 'x') {
					map[r][i] = '.';
					return;
				}
			}
		} else {
			for (int i = C - 1; i >= 0; i--) {
				if (map[r][i] == 'x') {
					map[r][i] = '.';
					return;
				}
			}
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

}