package ssafy0204;

import java.util.Scanner;

public class Solution_D4_1226_미로1 {
	static int T; // dummy
	static int matrix[][];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int sx, sy, ex, ey;
	static int visited[][];
	static int k;

	public static void DFS(int x, int y) {

		if (x == ex && y == ey) {
			k = 1;
			return;
		} else {
			for (int d = 0; d < 4; d++) {
				if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < 16 && y + dy[d] < 16
						&& matrix[x + dx[d]][y + dy[d]] == 0 && visited[x + dx[d]][y + dy[d]] == 0) {
					visited[x + dx[d]][y + dy[d]] = 1;
					DFS(x + dx[d], y + dy[d]);
					visited[x + dx[d]][y + dy[d]] = 0;
					if(k == 1)
						return;
					
				}
			}

		}
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		T= sc.nextInt();

		for (int test_case = 1; test_case <= 11; test_case++) {
			sx = sy = ex = ey = -1;
			T = sc.nextInt();
			k = 0;
			matrix = new int[16][16];
			visited = new int[16][16];
			for (int i = 0; i < 16; i++) {
				char[] c = new char[16];
				c = sc.next().toCharArray();
				for (int j = 0; j < 16; j++) {
					matrix[i][j] = c[j]-48;
					if (matrix[i][j] == 2) {
						sx = i;
						sy = j;
					}
					if (matrix[i][j] == 3) {
						ex = i;
						ey = j;
					}
				}
			}
			for (int i = 0; i < 16; i++) {
		
				for (int j = 0; j < 16; j++) {
					System.out.print( matrix[i][j] + " ");
				}
				System.out.println();
			}
		
//			if (sx == -1 || sy == -1 || ex == -1 || ey == -1) {
//				System.out.println("#" + test_case + " " + 0);
//				
//			}else {
//				visited[sx][sy] = 1;
//				DFS(sx, sy);
//				System.out.println("#" + test_case + " " + k);
//			}
		}
	}

}
