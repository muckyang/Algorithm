package Study_0225;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_17143_낚시왕 {
	static int N, M, S;
	static boolean[][] matrix;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Shark> al;

	private static class Shark {
		int x;
		int y;
		int speed;
		int d;
		int size;

		public Shark(int x, int y, int speed, int d, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.d = d;
			this.size = size;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.nextInt();
		for (int i = 0; i < S; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int speed = sc.nextInt();
			int d = sc.nextInt();
			int size = sc.nextInt();
			al.add(new Shark(x, y, speed, d, size));
		}
		
	}
}
