package Study_0308;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution_Unknown_1251_하나로 {
	static int T, N;
	static double E;
	static int mx[];
	static int my[];
	static long[][] map;
	static int[] v;
	static long res;
	static List<Point> plist;

	private static class Point {
		int from;
		int to;
		long dist;

		private Point(int from, int to, long dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new long[N][N];
			mx = new int[N];
			my = new int[N];
			v = new int[N];
			plist = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				mx[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				my[i] = sc.nextInt();
			}
			E = sc.nextDouble();
			res= 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long su = (long) Math.pow(mx[i] - mx[j], 2) + (long) Math.pow(my[i] - my[j], 2);
					plist.add(new Point(i, j, su));
				}
			}
			Collections.sort(plist, new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if (o1.dist < o2.dist) {
						return -1;
					} else if (o1.dist > o2.dist) {
						return 1;
					} else {
						return 0;
					}
				}

			});
			int union = 1;
			int cnt = 0;
			for (int i = 0; i < plist.size(); i++) {
				Point p = plist.get(i);
				if (cnt == N - 1)
					break;
				if (v[p.to] == 0 && v[p.from] == 0) {
					v[p.to] = v[p.from] = union;
					cnt++;
					union++;
					res += p.dist;
				} else if (v[p.to] == 0 && v[p.from] != 0) {
					v[p.to] = v[p.from];
					res += p.dist;
					cnt++;
				} else if (v[p.to] != 0 && v[p.from] == 0) {
					v[p.from] = v[p.to];
					res += p.dist;
					cnt++;
				} else if (v[p.to] == v[p.from]) {
					continue;
				} else if (v[p.to] != v[p.from]) {
					int t = v[p.to];
					int f = v[p.from];
					res += p.dist;
					cnt++;
					for (int k = 0; k < v.length; k++) {
						if (v[k] == f) {
							v[k] = t;
						}
					}
				}
			}
			System.out.println("#"+ tc+" " + (long)(Math.round(res * E)));
		}
	}
}
