package Study_0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	static int N, M;
	static char map[][];
	static int dx[] = { 0, 1, 0, -1 };// 동남서북
	static int dy[] = { 1, 0, -1, 0 };
	static int sx, sy, ex, ey;
	static Queue<Pipe> q;
	static Pipe res;

	public static class Pipe {
		int x, y;
		int d;
		char shape;
		Pipe del;

		public Pipe(int x, int y, int d, char shape) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.shape = shape;
			this.del = null;
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
					q.add(new Pipe(i, j, -1, 'M'));// 처음은 +로 처리
				}
			}
		}
		solve();
		System.out.println(res.x + " " + res.y + " " + res.shape);
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pipe p = q.poll();
				if (map[p.x][p.y] == 'Z') {
					res = p.del;
					return;
				}
				for (int d = 0; d < 4; d++) {
					if (p.d == d)
						continue;
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || !canGo(p, d))
						continue;
					if(map[ix][jy] == '.' && p.del == null) {
//						Pipe a = new Pipe(ix,jy,d);
					}

				}
			}
		}
	}

	private static boolean canGo(Pipe p, int d) {
		char c = map[p.x][p.y];
		if (c == 'M')
			return true;
		else if (c == '+' && p.d % 2 != d % 2)
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
