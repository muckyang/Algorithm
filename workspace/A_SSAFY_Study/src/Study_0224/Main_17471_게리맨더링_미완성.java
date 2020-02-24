package Study_0224;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_17471_게리맨더링_미완성 {
	static int N, min;
	static int[] people;
	static boolean[][] graph;
	static boolean[] acheck;
	static boolean[] bcheck;
	static boolean[] va;
	static boolean[] vb;

	static ArrayList<Point> al;
	static ArrayList<Point> bl;

	private static class Point {
		int x;

		public Point(int x) {
			this.x = x;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N];
		graph = new boolean[N][N];
		al = new ArrayList<>();
		bl = new ArrayList<>();

		acheck = new boolean[N];
		bcheck = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			people[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				int n = sc.nextInt() - 1;
				graph[i][n] = true;
				graph[n][i] = true;
			}
		}
		combi(0, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void combi(int start, int c) {
		if (c == N) {
			return;
		}
		if (c != 0) {
			int asum = 0;
			int bsum = 0;
			int res;
			va = new boolean[N];
			vb = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (acheck[i]) {
					al.add(new Point(i));
					asum += people[i];
					System.out.print(i + " ");
				} else {
					bsum += people[i];
					bl.add(new Point(i));
				}
			}
		System.out.println();

			if (arraycheck(al, 1) && arraycheck(bl, 2)) {
				System.out.println(asum +" ===== " + bsum);
				res = Math.abs(asum - bsum);
				if (res < min) {
					min = res;
				}
			}
		}
		for (int i = start; i < N; i++) {
			if (!acheck[i]) {
				acheck[i] = true;
				combi(i + 1, c + 1);
				acheck[i] = false;
			}
		}

	}

	private static boolean arraycheck(ArrayList<Point> ar, int ab) {
		Point p = ar.get(0);
		int start = p.x;

		if (check(start, ar, ab, 0)) {
			return true;
		}

		return false;
	}

	private static boolean check(int start, ArrayList<Point> ar, int ab, int c) {
		if (ab == 1) {
			va[start] = true;
			if (c == ar.size())
				return true;
			for (int i = 0; i < N; i++) {
				if (acheck[i] && !va[i] && graph[start][i]) {
					va[i] = true;
					check(i, ar, ab, c + 1);
				}
			}
		} else {
			vb[start] = true;
			if (c == ar.size())
				return true;
			for (int i = 0; i < N; i++) {
				if (bcheck[i] && !vb[i] && graph[start][i]) {
					vb[i] = true;
					check(i, ar, ab, c + 1);
				}
			}
		}
		return false;
	}
}
