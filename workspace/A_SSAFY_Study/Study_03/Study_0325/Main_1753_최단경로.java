package Study_0325;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1753_최단경로 {
	static int V, E;
	static int dest;
	static ArrayList<ArrayList<Point>> map;
	static boolean list[];
	static PriorityQueue<Point> pq;
	static int res;

	static class Point implements Comparable<Point> {
		int y;
		int v;

		public Point( int y, int v) {
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		dest = sc.nextInt() - 1;
		map = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			map.add(new ArrayList<Point>());
		}
		for (int i = 0; i < E; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int v = sc.nextInt();
			map.get(x).add(new Point( y, v));
		}

		for (int i = 0; i < V; i++) {
			if (i == dest)
				System.out.println(0);
			else {
				res = 0;
				list = new boolean[V];
				pq = new PriorityQueue<Point>();
				for (int k = 0; k < map.get(dest).size(); k++) {
						list[map.get(dest).get(k).y] = true;
						pq.add(new Point(map.get(dest).get(k).y, map.get(dest).get(k).v));
				}
				solve(i);
				if (res == 0)
					System.out.println("INF");
				else
					System.out.println(res);
			}
		}
	}

	private static void solve(int target) {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (p.y == target) {
				res = p.v;
				return;
			} else {
				for (int i = 0; i < map.get(p.y).size(); i++) {
					if (!list[map.get(p.y).get(i).y]) {
						list[map.get(p.y).get(i).y] = true;
						pq.add(new Point( map.get(p.y).get(i).y, map.get(p.y).get(i).v + p.v));
					}
				}
			}
		}
	}
}
