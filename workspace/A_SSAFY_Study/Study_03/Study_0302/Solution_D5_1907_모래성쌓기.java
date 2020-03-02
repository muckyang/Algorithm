package Study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1907_모래성쌓기 {
	static int T, N, M, res;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dy = { 1, -1, 1, 0, -1, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			res = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					if (s.charAt(j) == '.')
						map[i][j] = 0;
					else
						map[i][j] = s.charAt(j) - '0';
				}
			}
			// 입력확인ok
			solve();
			System.out.println("#" + tc + " " + res);
		}
	}

	private static void solve() {

		boolean check = true;
		while (check) {
			check = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && map[i][j] != 9) {
						int cnt = 0;
						for (int d = 0; d < 8; d++) {
							int ix = i + dx[d];
							int jy = j + dy[d];
							if (map[ix][jy] == 0) {
								cnt++;
							}
						}
						if (cnt >= map[i][j]) {
							map[i][j] = -1;
							if (!check) {
								check = true;
								res++;
							}
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == -1)
						map[i][j] = 0;
				}
			}

		}
	}
}
