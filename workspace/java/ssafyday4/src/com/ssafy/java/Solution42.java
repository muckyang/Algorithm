package com.ssafy.java;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution42 {
	static int N, Si, Sj, P, D;
	//static int Ai, Aj;

	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution42.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			// 시작좌표
			Si = sc.nextInt();
			Sj = sc.nextInt();

			P = sc.nextInt();

			matrix = new int[N + 2][N + 2];// 테두리까지 계산
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == 0 || j == 0 || i == N + 1 || j == N + 1)
						matrix[i][j] = 1;// 테두리까지 는 1 지정
				}
			}

			int Pi[] = new int[P];
			int Pj[] = new int[P];
			// 점퍼 좌표
			for (int k = 0; k < P; k++) {
				Pi[k] = sc.nextInt();
				Pj[k] = sc.nextInt();
				matrix[Pi[k]][Pj[k]] = 1;// 점퍼에 1 값줌
			}

//			for(int i = 0 ; i < N+2; i++) {
//				for(int j = 0 ; j < N+2; j++) {
//					System.out.print(matrix[i][j]+" ");
//				}
//				System.out.println();
//			}

			D = sc.nextInt();
			int Dd[] = new int[D];
			int Da[] = new int[D];

			for (int k = 0; k < D; k++) {
				Dd[k] = sc.nextInt();
				Da[k] = sc.nextInt();
			}

			for (int i = 0; i < D; i++) {
				
				for (int go = 0; go < Da[i]; go++) {// 횟수
					Si = Si + dy[Dd[i]];
					Sj = Sj + dx[Dd[i]];
					if (matrix[Si][Sj] == 1) {
						Si=0;
						Sj=0;
						break;
					}
				}
				if (matrix[Si][Sj] == 1) {
					Si=0;
					Sj=0;
					break;
				}
			}
			System.out.println("#" + test_case + " " + Si + " " + Sj);
		}
	}
}
