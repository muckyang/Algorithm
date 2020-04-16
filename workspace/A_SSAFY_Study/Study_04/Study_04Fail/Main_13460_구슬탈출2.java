package Study_04Fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13460_구슬탈출2 {
	static int N, M;
	static int map[][];
	static int dx[] = { -1, 1, 0, 0 };// 상 하 좌 우
	static int dy[] = { 0, 0, -1, 1 };
	static int mapp[][];
	static int list[];
	static boolean red, blue;
	static int rx, ry, bx, by;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		list = new int[10];
		res = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '.')
					map[i][j] = 0;
				else if (c == '#')
					map[i][j] = -1;
				else if (c == 'O')
					map[i][j] = 1;
				else if (c == 'R') {
					rx = i;
					ry = j;
					map[i][j] = 2;
				} else if (c == 'B') {
					bx = i;
					by = j;
					map[i][j] = 3;

				}
			}
		}
//		print(map);
		combi(0, 100);// count , back

		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	private static void print(int[][] mat) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void combi(int count, int back) {
		if (count == 5 || count >= res)
			return;
		if (count != 0) {
			mapp = new int[N][M];
			red = blue = true;
			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, mapp[i], 0, map[i].length);

//			slide(list, count, rx, ry, bx, by);
			Queue<int[]> q = new LinkedList<>();
//			q.add();
			while(!q.isEmpty()) {
				
			}
			if (!blue) {
				return;
			} else if (!red) {
				if (res > count)
					res = count;
				return;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (i != back && i != back + 2 && i != back - 2) {
				list[count] = i;
				combi(count + 1, i);
			}
		}

	}

}
