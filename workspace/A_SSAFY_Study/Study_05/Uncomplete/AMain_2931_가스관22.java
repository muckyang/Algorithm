package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_2931_가스관22 {
	static int N, M;
	static int map[][];
	static int dx[] = { 0, 1, 0, -1 };// 동남서북
	static int dy[] = { 1, 0, -1, 0 };
	static int pipeTF[][] = { { 0, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 },
			{ 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 1, 1, 1, 1 }, }; // 나가는게 1 이면 가능 ( . ,1,2,3,4 ,|,-,+)
	static int sx, sy, ex, ey;
	static Queue<Pipe> q;
	static Pipe res;

	public static class Pipe {
		int x, y;
		int d;
		int shape;
		Pipe del;

		public Pipe(int x, int y, int d, int shape) {
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
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == 'Z') {
					ex = i;
					ey = j;
					map[ex][ey] = -1;
				} else if (c == 'M') {
					sx = i;
					sy = j;
					map[i][j] = -2;
					q.add(new Pipe(i, j, -1, 7));// 처음은 +로 처리
				} else if (c == '.') {
					map[i][j] = 0;
				} else if (c == '1') {
					map[i][j] = 1;
				} else if (c == '2') {
					map[i][j] = 2;
				} else if (c == '3') {
					map[i][j] = 3;
				} else if (c == '4') {
					map[i][j] = 4;
				} else if (c == '|') {
					map[i][j] = 5;
				} else if (c == '-') {
					map[i][j] = 6;
				} else if (c == '+') {
					map[i][j] = 7;
				}
			}
		}
//		print();
		res = new Pipe(0, 0, 0, 0);

		solve();

		if (res != null) {
			char c = (char) (res.shape + '0');
			if (res.shape == 5)
				c = '|';
			if (res.shape == 6)
				c = '-';
			if (res.shape == 7)
				c = '+';
			System.out.println(res.x + " " + res.y + " " + c);
		}
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pipe p = q.poll();
//				System.out.println(p.x + " ," + p.y + " p.d : " + p.d + " p.shape : " + p.shape);
				if (map[p.x][p.y] == -1) {
					res = new Pipe(p.del.x + 1, p.del.y + 1, p.del.d, p.del.shape);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int id = d - 2; // 반대방향
					if (id < 0)
						id = 4 + id;
					if (id == p.d && p.d != -1)
						continue;
					if (pipeTF[p.shape][d] == 0)// 나가는 방향이 열려있는가?
						continue;
					if (p.shape == 7 && p.d != -1 && p.d != d)
						continue;
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || map[ix][jy] == -2) // 범위 밖인지 여부
						continue;
					if (map[ix][jy] == 0) {// 다음이 '.' 이라면
						if (p.del == null) { // 아직 사용하지 않은경우
							for (int k = 1; k < 8; k++) {
								if (pipeTF[k][id] == 1) {// 받을수 있는경우
									Pipe pp = new Pipe(ix, jy, d, k);
									pp.del = new Pipe(ix, jy, d, k);
									q.add(pp);
								}
							}
						} else {// 이미 사용한 경우
							continue;
						}
					} else { // 파이프가 연결된경우
						if (map[ix][jy] == -1) {
							Pipe pp = new Pipe(ix, jy, d, map[ix][jy]);
							pp.del = p.del;
							q.add(pp);
						} else if (pipeTF[map[ix][jy]][id] == 1) {// 받을수 있는경우
							Pipe pp = new Pipe(ix, jy, d, map[ix][jy]);
							pp.del = p.del;
							q.add(pp);
						}
					}
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