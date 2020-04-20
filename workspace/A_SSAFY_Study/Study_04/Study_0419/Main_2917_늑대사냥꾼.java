package Study_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2917_늑대사냥꾼 {
	static int N, M;
	static List<Point> tlist;
	static int map[][];
	static boolean v[][];
	static int res, sx, sy, ex, ey;
	static PriorityQueue<Point> pq;
	static Queue<Point> q;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static class Node {
		int x;
		int y;
		int v;
		Node prev;
		
	}
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		
		tlist = new LinkedList<>();
		pq = new PriorityQueue<>();
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '+') {
					map[i][j] = -1;
					tlist.add(new Point(i, j, 0));
					q.add(new Point(i, j, 0));
				} else if (c == 'V') {
					v[i][j] = true;
					sx = i;
					sy = j;
				} else if (c == 'J') {
					ex = i;
					ey = j;
				}
			}
		}
		int depth = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && map[ix][jy] == 0) {
						map[ix][jy] = depth;
						v[ix][jy] =true;
						q.add(new Point(ix, jy, 0));
					}
				}
			}
			depth++;
		}
		pq.add(new Point(sx,sy,map[sx][sy]));
		v = new boolean[N][M];
		v[sx][sy] = true;
		while(!pq.isEmpty()) {
			
		}
		
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
