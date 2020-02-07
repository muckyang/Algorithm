package com.ssafy.java;

import java.util.Scanner;

public class Solution13_건물짓기 {
	static int T;
	static int N;
	static int[][] matrix;
	static int[][] floor;
	static int max;
	static int[] check;
	static int[] dx = { 1, -1, 0, 0, 1, -1, -1, 1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	public static int B_len(int x, int y) {
		int f_count = 1;//자신포함
		for(int i = 0 ; i < N;i++) {
			if( i == x )
				continue;
			if(floor[i][y] != 1)
				f_count++;
		}
		for(int i = 0 ; i < N;i++) {
			if( i == y )
				continue;
			if(floor[x][i] != 1)
				f_count++;
		}
		return f_count;
	}
	public static void check_8Way(int x, int y) {// 위,오,아,왼
		check = new int[8]; // 1이면 벽 , 0 이면 진행가능
		if (x == N - 1) {// 위가없다
			check[0] = check[4] = check[7] = 1;
		}
		if (y == N-1) {// 오른쪽이 없다
			check[2] = check[4] = check[6] = 1;
		}
		if (x == 0) {// 아래가없다
			check[1] = check[5] = check[6] = 1;
		}
		if (y == 0) {// 왼쪽이 없다
			check[3] = check[5] = check[7] = 1;
		}
		for (int i = 0; i < 8; i++) {
			if (check[i] == 1) {
				continue;
			}
			if (matrix[x + dx[i]][y + dy[i]] == 1) {
				floor[x][y] = 2;
				break;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			matrix = new int[N][N];
			floor = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (sc.next().charAt(0) == 'G') {
						matrix[i][j] = 1;
						floor[i][j] = 1;
					} else
						matrix[i][j] = 0; // B
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == 0) {
						check_8Way(i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (floor[i][j] == 0) {

						max = max < B_len(i, j) ? B_len(i, j) : max;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
			max =0 ;
			
		}
	}
}
