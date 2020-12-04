package Algo_2020_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Songlution {

	static int N;
	static int M;
	static int Oil;
	static int[][] map;
	static int[][] copymap;
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	static Point[] data;
	static Point[] startdata;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean[][] visit;
	static boolean[][] copyvisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Oil = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int m = Integer.parseInt(st.nextToken());
				if (m == 1) {
					map[i][j] = -1;// 벽
					visit[i][j] = true;
				} else {
					map[i][j] = m;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int ti = Integer.parseInt(st.nextToken()) - 1;
		int tj = Integer.parseInt(st.nextToken()) - 1;
		pq.offer(new Point(ti, tj, 0));
		data = new Point[M + 1];// 미리 담을 객체배열

		startdata = new Point[M + 1];// 미리 담을 객체배열
		copymap = new int[N][N];
		copyvisit = new boolean[N][N];

		for (int m = 1; m <= M; m++) {
			for (int j = 0; j < N; j++) {// 복사
				System.arraycopy(map[j], 0, copymap[j], 0, N);
			}
			for (int j = 0; j < N; j++) {// 복사
				System.arraycopy(visit[j], 0, copyvisit[j], 0, N);
			}
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken()) - 1;
			int sj = Integer.parseInt(st.nextToken()) - 1;
			int ei = Integer.parseInt(st.nextToken()) - 1;
			int ej = Integer.parseInt(st.nextToken()) - 1;
			startdata[m] = new Point(si, sj, 0);
			map[si][sj] = m;// 본 맵에 표시
			Queue<Point> que = new LinkedList<>();// 승객의 도착지점까지의 최소거리를 미리 구함
			que.offer(new Point(si, sj, 0));
			copyvisit[si][sj] = true;
			while (!que.isEmpty()) {
				boolean flag = false;
				int size = que.size();
				for (int s = 0; s < size; s++) {
					Point p = que.poll();
					for (int d = 0; d < 4; d++) {
						int ny = p.i + dy[d];
						int nx = p.j + dx[d];
						if (!safe(ny, nx) || copyvisit[ny][nx])
							continue;
						if (copymap[ny][nx] == -1)
							continue;
						if (ny == ei && nx == ej) {
							data[m] = new Point(ei, ej, p.dis + 1);
							flag = true;
							s = size;
							break;
						}
						que.offer(new Point(ny, nx, p.dis + 1));
						copyvisit[ny][nx] = true;
					}
				}
				if (flag) {
					break;
				}
			}
		}
		for (int j = 1; j <= M; j++) {
			if (data[j] == null) {
				System.out.println(-1);
				return;
			}
		}
		for (int j = 0; j < N; j++) {// 복사
			System.arraycopy(visit[j], 0, copyvisit[j], 0, N);
		}
		copyvisit[ti][tj] = true;
		// 택시부터 가까운 승객 태우기
		int cnt = 1;
		while (!pq.isEmpty()) {
			if (cnt == M + 1) {
				System.out.println(Oil);
				return;
			}
			int size = pq.size();
			for (int s = 0; s < size; s++) {
				Point p = pq.poll();
				if (map[p.i][p.j] != 0) {
					Oil = Oil - (p.dis);
					if (Oil <= 0) {
						System.out.println("-1");
						return;
					}
					Oil = Oil - data[map[p.i][p.j]].dis;
					if (Oil < 0) {
						System.out.println("-1");
						return;
					}

					Oil = Oil + (2 * data[map[p.i][p.j]].dis);
					pq.clear();// 다시 세팅
					pq.offer(new Point(data[map[p.i][p.j]].i, data[map[p.i][p.j]].j, 0));
					for (int j = 0; j < N; j++) {// 복사
						System.arraycopy(visit[j], 0, copyvisit[j], 0, N);
					}
					copyvisit[data[map[p.i][p.j]].i][data[map[p.i][p.j]].j] = true;
					cnt++;
					map[p.i][p.j] = 0;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int ny = p.i + dy[d];
					int nx = p.j + dx[d];
					if (!safe(ny, nx) || copyvisit[ny][nx] || map[ny][nx] == -1)
						continue;

					copyvisit[ny][nx] = true;
					pq.offer(new Point(ny, nx, p.dis + 1));
				}
			}
		}
		System.out.println("-1");

	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N)
			return true;
		else
			return false;
	}

	public static class Point implements Comparable<Point> {
		int i;
		int j;
		int dis;

		public Point(int i, int j, int dis) {
			super();
			this.i = i;
			this.j = j;
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", dis=" + dis + "]";
		}

		@Override
		public int compareTo(Point o) {
			if (this.dis > o.dis) {
				return 1;
			} else if (this.dis == o.dis) {
				if (this.i > o.i) {
					return 1;
				} else if (this.i == o.i) {
					if (this.j > o.j) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
	}
}
