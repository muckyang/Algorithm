package ING;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_1486_등산_미완성 {
	static int N, M, T, D;
	static int map[][];
	static int v[][];
	static int res;
	static Queue<Point> q;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());// 높이 최대 차이
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (0 <= c - 'a' && c - 'z' <= 0) {
					map[i][j] = c - 'a' +26;
				} else {
					map[i][j] = c - 'A' ;
				}
			}
		}
		print();
		res = map[0][0]; // 시작지점이 최소높이
		q = new LinkedList<>();
		q.add(new Point(0, 0));
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
