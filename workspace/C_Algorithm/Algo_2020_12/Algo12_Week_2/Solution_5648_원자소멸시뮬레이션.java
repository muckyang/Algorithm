package Algo12_Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//시간초과 , 2000,2000 매번도는게 문제다..
//해쉬맵으로 해보자! 
public class Solution_5648_원자소멸시뮬레이션 {
	static int cnt[][];
	static boolean v[][];
	static Oneja[][] map;
	static Queue<Oneja> q;
	static int dx[] = { 0, 0, -1, 1 }; // 상,하,좌,우
	static int dy[] = { 1, -1, 0, 0 }; // 상,하,좌,우
	static int res;

	public static class Oneja {
		int x, y;
		int d, power;

		public Oneja(int x, int y, int d, int power) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.power = power;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new Oneja[2002][2002];
			v = new boolean[2002][2002];
			cnt = new int[2002][2002];
			q = new LinkedList<>();
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) + 1000;
				int y = Integer.parseInt(st.nextToken()) + 1000;
				int d = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				map[x][y] = new Oneja(x, y, d, power);
				q.add(new Oneja(x, y, d, power));
				v[x][y] = true;
			}
			solve();
			System.out.println("#" + t + " " + res);
		}
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			Oneja[][] temp = new Oneja[2002][2002];
			cnt = new int[2002][2002];
			for (int i = 0; i < size; i++) {
				Oneja p = q.poll();
				if (!v[p.x][p.y])// 이미충돌났다면?
					continue;

				v[p.x][p.y] = false;
				int jy = p.y + dy[p.d];
				int ix = p.x + dx[p.d];
				if (jy > 2001 || ix > 2001 || ix < 0 || jy < 0)
					continue;
				// 0.5처리
				if (p.d % 2 == 0) {
					if (v[ix][jy] && map[ix][jy].d == p.d + 1) {
						v[ix][jy] = false;
						res += (p.power + map[ix][jy].power);
						continue;
					}
				} else {
					if (v[ix][jy] && map[ix][jy].d == p.d - 1) {
						v[ix][jy] = false;
						res += (p.power + map[ix][jy].power);
						continue;
					}
				}
				// 0.5 처리 끝

				if (cnt[ix][jy] == 0) {
					cnt[ix][jy]++;
					temp[ix][jy] = new Oneja(ix, jy, p.d, p.power);
				} else {
					cnt[ix][jy]++;
					temp[ix][jy].power += p.power;
				}

			}
			v = new boolean[2002][2002];
			for (int a = 0; a < 2002; a++) {
				for (int b = 0; b < 2002; b++) {
					if (cnt[a][b] == 0)
						continue;
					if (cnt[a][b] == 1) {
						v[a][b] = true;
						q.add(temp[a][b]);
					} else {
						res += temp[a][b].power;
					}

				}
			}
			for (int k = 0; k < 2002; k++)
				System.arraycopy(temp[k], 0, map[k], 0, 2002);

		}
	}

}
