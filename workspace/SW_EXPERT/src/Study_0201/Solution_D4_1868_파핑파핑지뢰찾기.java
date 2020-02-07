package Study_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int[][] matrix;
	static char[][] mine;
	static boolean[][] flag;
	static int[] dx = { -1, 0, 1, 0, 1, -1, -1, 1 };
	static int[] dy = { 0, -1, 0, 1, -1, -1, 1, 1 };

	static int T;
	static int N;
	static int count;

	public static int check_8Way(int x, int y, int check) {
		int count_this = 0;
		if (check == 1) {
			for (int d = 0; d < 8; d++) {
				if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N
						&& mine[x + dx[d]][y + dy[d]] == '*')
					count_this++;
			}
		} else {
			for (int d = 0; d < 8; d++) {
				if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N
						&& matrix[x + dx[d]][y + dy[d]] == 0)
					count_this++;
			}
		}
		return count_this;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			matrix = new int[N][N];
			flag = new boolean[N][N];
			mine = new char[N][N];
			for (int i = 0; i < N; i++) { // 지뢰 입력받음
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					mine[i][j] = s.charAt(j);
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mine[i][j] == '*') { // 지뢰라면
						matrix[i][j] = -1;
						flag[i][j] = true;
					} else { // 빈자리
						matrix[i][j] = check_8Way(i, j, 1);
					}

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] > 0 && check_8Way(i, j, 0) == 0) {
						count++;
						flag[i][j] = true;
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					int k = 0;
//					if (matrix[i][j] == 0 && flag[i][j] == false) {
//						count++;
//						
//						// System.out.println(" +++++("+i+ " " + j +")");
//						for (int d = 0; d < 4; d++) {
//							// System.out.println("("+(i+dx[d])+ " " + (j+dy[j]) +")");
//							if (i + dx[d] >= 0 && j + dy[d] >= 0 && i + dx[d] < N && j + dy[d] < N
//									&& flag[i + dx[d]][j + dy[d]] == true) {
//								if (k == 0) {
//									count--;
//									k = 1;
//								}
//							}
//							else if (i + dx[d] >= 0 && j + dy[d] >= 0 &&
//									i + dx[d] < N && j + dy[d] < N)
//								flag[i + dx[d]][j + dy[d]] = true;
//						}
//						flag[i][j] = true;
//					}
//				}
//			}

//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					System.out.print( flag[i][j] == true ? 1  + " ": 0  + " ");
//				}
//				System.out.println();
//			}
//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					System.out.print( matrix[i][j] + " ");
//				}
//				System.out.println();
//			}

			System.out.println("#" + test_case + " " + count);
		}
	}
}
