package Study_0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19237_어른상어 {
	static int N, M, K;
	static int see[];
	static int map[][];
	static int temp[][];
	static int smell[][];
	static int time[][];
	static int priority[][][];
	static PriorityQueue<Shark> pq;
	static int res;
	static int dx[] = { 0, -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 0, -1, 1 };

	public static class Shark implements Comparable<Shark> {
		int x, y, size;

		public Shark(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			return this.size - o.size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵크기
		M = Integer.parseInt(st.nextToken()); // 상어수
		K = Integer.parseInt(st.nextToken()); // 냄새 지속시간
		map = new int[N][N];
		temp = new int[N][N];
		smell = new int[N][N];
		time = new int[N][N];
		see = new int[N + 1];
		priority = new int[M + 1][5][4];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					pq.add(new Shark(i, j, map[i][j]));
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			see[i] = Integer.parseInt(st.nextToken());
		}

		// 상 하 좌 우 순으로 우선순위 주어짐
		for (int i = 1; i < M + 1; i++) { // 상어번호
			for (int j = 1; j <= 4; j++) {// 보는 방향
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) { // 우선순위
					priority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		res = -1;
		solve();
		System.out.println(res);
	}

	private static void solve() {
		int time = 0;
		while (!pq.isEmpty()) {
			int size = pq.size();
			// 한마리만 남은지 체크
			if (size == 1) {
				res = time;
				return;
			}
			// 1000초 경과
			if (time >= 1000)
				return;

			for (int s = 0; s < size; s++) {

			}
			time++;
		}

	}

}
