package Algo03_Week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {
	static int N;
	static int[][] map;
	// 상어의 이동거리
	static int sharkMoveCnt;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer tk = null;
		Shark shark = null;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0, 0);
					map[i][j] = 0;
				}
			}
		}

		bfs(shark);
		System.out.println(sharkMoveCnt);

	}

	private static void bfs(Shark shark) {
		Queue<Shark> que = new LinkedList<>();
		que.offer(shark);

		boolean[][] visited = new boolean[N][N];
		visited[shark.row][shark.col] = true;

		// 먹을 수 있는 물고기를 저장할 pq
		PriorityQueue<Fish> pque = new PriorityQueue<>();
		Shark front = null;
		findfish: while (!que.isEmpty()) {
			front = que.poll();
			for (int d = 0; d < dirs.length; d++) {
				int ny = front.row + dirs[d][0];
				int nx = front.col + dirs[d][1];
				if (check(ny, nx) && !visited[ny][nx]) {
					visited[ny][nx] = true;
					// 이동한 점의 값에 따라 분기처리.
					if (map[ny][nx] == 0 || map[ny][nx] == front.size) { // 이동만
						que.offer(new Shark(ny, nx, front.size, front.depth + 1, front.eatCnt));
					} else if (map[ny][nx] < front.size) { // 먹을수 있다
						if (pque.isEmpty()) {
							pque.offer(new Fish(ny, nx, map[ny][nx], front.depth + 1));
						} else {
							Fish first = pque.peek();//현재 pq의 가장 우선인 물고기
							if (first.dist < front.depth + 1) {// 현재 같은 뎁스인지확인
								break findfish;
							} else {
								pque.offer(new Fish(ny, nx, map[ny][nx], front.depth + 1));
							}
						}
					}
				}
			}
		}
		if (pque.isEmpty()) {
			return;
		} else {// 맨처음 물고기를 먹음
			Fish food = pque.poll();
			front.eat();
			map[food.row][food.col] = 0;

			sharkMoveCnt += food.dist;
			bfs(new Shark(food.row, food.col, front.size, 0, front.eatCnt));
		}
	}

	static class Fish implements Comparable<Fish> {
		int row, col, size, dist;

		public Fish(int row, int col, int size, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.row == o.row) {
					return Integer.compare(this.col, o.col);
				} else {
					return Integer.compare(this.row, o.row);
				}
			} else {
				return Integer.compare(this.dist, o.dist);
			}
		}

	}

	static boolean check(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < N;
	}

	static class Shark {
		int row, col;
		int size; // 크기
		int depth; // bfs 탐색 너비
		int eatCnt; // 먹은 마리수

		public Shark(int row, int col, int size, int depth, int eatCnt) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.depth = depth;
			this.eatCnt = eatCnt;
		}

		public void eat() {
			eatCnt++;
			if (eatCnt == size) {
				size++;
				eatCnt = 0;
			}
		}

	}
}
