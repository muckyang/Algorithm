package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_2931_가스관3 {
	static int N, M;
	static char map[][];
	static int dx[] = { 0, 1, 0, -1 };// 동남서북
	static int dy[] = { 1, 0, -1, 0 };
	static int pipeTF[][] = { { 0, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 },
			{ 0, 1, 0, 1 }, { 1, 0, 1, 0 } }; // 들어오는 기준 0 이면 가능
	static int sx, sy, ex, ey;
	static Queue<Pipe> q;

	static char shape;
	static int px, py;

	static Pipe res;

	public static class Pipe {
		int x, y;
		int d;
		char shape;

		public Pipe(int x, int y, int d, char shape) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.shape = shape;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		res = null;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'Z') {
					ex = i;
					ey = j;
				} else if (map[i][j] == 'M') {
					sx = i;
					sy = j;
					q.add(new Pipe(i, j, -1,'0'));
				}
			}
		}
		Pipe p = q.poll();
		for (int d = 0; d < 4; d++) {
			int ix = p.x + dx[d];
			int jy = p.y + dy[d];
			if (safe(ix, jy) && canGo(ix, jy, d)) {
				q.add(new Pipe(ix, jy, d , map[ix][jy]));
				break;
			}
		}
		solve();
		System.out.println(res.x + " " + res.y + " " + res.shape);
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size ; i++) {
				
			}
		}
	}

	private static boolean canGo(int x, int y, int d) {
		char c = map[x][y];

		if (c == '+')
			return true;
		else if (c == '-' && d % 2 == 0)
			return true;
		else if (c == '|' && d % 2 == 1)
			return true;
		else if (c == '1' && d < 2)// 동남
			return true;
		else if (c == '2' && (d == 0 || d == 3)) // 동북
			return true;
		else if (c == '3' && d > 1) // 서,북
			return true;
		else if (c == '4' && (d == 1 || d == 2)) // 남서
			return true;

		return false;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}