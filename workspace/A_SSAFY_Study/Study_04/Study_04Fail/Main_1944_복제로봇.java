package Study_04Fail;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_1944_복제로봇 {
	static int N, M;
	static int sx, sy;
	static int kx[];
	static int ky[];

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };
	static char map[][];
	static int dist[][];
	static Queue<PP> q;
	static boolean link;
	static int value;
	static PriorityQueue<Point> pq;
	static int res;

	static class PP {
		int x;
		int y;

		public PP(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int v;

		public Point(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int cnt = 1;
		res = 0;
		map = new char[N][N];
		dist = new int[M + 1][M + 1];// 인접행렬
		kx = new int[M + 1];// s,k x좌표
		ky = new int[M + 1];// s,k y좌표
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				if (c == 'S') {
					kx[0] = i;
					ky[0] = j;
					map[i][j] = 0;
				} else if (c == 'K') {
					kx[cnt] = i;
					ky[cnt] = j;
					cnt++;
					map[i][j] = 0;
				} else {
					map[i][j] = c;
				}
			}
		}
		boolean canLink = true;
		for (int k = 0; k <= M; k++) {
			q = new LinkedList<>();
			q.add(new PP(kx[k], ky[k]));
			bfs(k);
			canLink = canLinked(k);
			if (!canLink) {
				res = -1;
				break;
			}

		}
		/// 인접행렬 완성

		if (!canLink)
			System.out.println(res);
		else {

			System.out.println(res);
		}

	}

	private static boolean canLinked(int k) {
		if (k == 0) {
			for (int i = 1; i <= M; i++) {
				if (dist[0][i] == 0)
					return false;
			}
		}
		return true;
	}

	private static void bfs(int sp) {
		boolean v[][] = new boolean[N][N];
		v[sp][sp] = true;
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				PP p = q.poll();
				for (int t = 0; t <= M; t++) { // 모든 K 확인
					if(sp == t)
						continue;
					if (kx[t] == p.x && ky[t] == p.y) {
						dist[sp][t] = dist[t][sp] = res;
						pq.add(new Point(sp, t, res));
					}
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && !v[ix][jy] && map[ix][jy] == '0') {
						v[ix][jy] = true;
						q.add(new PP(ix, jy));
					}
				}
			}
			res++;
		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < N && jy < N)
			return true;
		return false;
	}
}
