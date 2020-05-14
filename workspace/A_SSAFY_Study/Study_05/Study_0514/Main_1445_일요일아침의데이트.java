package Study_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시작과 꽃 위치는 쓰레기 , 쓰레기 인접이어도 상관없음
public class Main_1445_일요일아침의데이트 {
	static int N, M;
	static int map[][];
	static int v[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q;
	static int sx, sy, fx, fy;
	static int res;

	public static class Point {
		int x, y;
		int ginc;

		public Point(int x, int y, int ginc) {
			this.x = x;
			this.y = y;
//			this.gc = gc;
			this.ginc = ginc;
		}
	}

	public static class Garbage {
		int ginc;

		public Garbage(int ginc) {
//			this.gc = gc;
			this.ginc = ginc;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		map = new int[N][M];
		v = new int[N][M];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				Arrays.fill(v[i], Integer.MAX_VALUE);
				if (c == 'S') {
					sx = i;
					sy = j;
				} else if (c == 'F') {
					fx = i;
					fy = j;
				} else if (c == 'g') {
					map[i][j] = 2;// 쓰레기 위치
					for (int d = 0; d < 4; d++) {
						int ix = i + dx[d];
						int jy = j + dy[d];
						if (!safe(ix, jy) || map[ix][jy] == 2)
							continue;
						map[ix][jy] = 1;// 쓰레기 주변
					}
				}
			}
		}
		q.add(new Point(sx, sy, 0));
		v[sx][sy] = 0;
		solve();

//		print();
//		System.out.println(v[fx][fy]+ " " + res);
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					int ginc = p.ginc;// 쓰레기 인접 지난 수
					if (!safe(ix, jy))
						continue;

					if (ix == fx && jy == fy) {
						if (res > p.ginc)
							res = p.ginc;
					}
					if(map[ix][jy] == 2 && v[ix][jy] >map[p.x][p.y]+1 )
						v[ix][jy] = map[p.x][p.y]+1;
					if(map[ix][jy] == 1 )
						ginc++;
					q.add(new Point(ix, jy,ginc));

				}

			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
