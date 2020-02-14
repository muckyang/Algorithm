package Study_0211;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] matrix;

	class Point {
		int x;
		int y;

	}

	public static void func(int start, int archer) {
		if (archer == 3) {
			gowar(matrix);// 복사해서 넣어야 할듯? 
			// 공격시작 함수실행
			return;
		}

		for (int i = start; i < M; i++) {
			matrix[N][i] = 1;
			func(i + 1, archer + 1);
		}
	}

	public static void gowar(int[][] mat) {
		Queue<Point> mon = new LinkedList<>(); // 죽일 대상 좌표넣는 큐
		int[] arc = new int[3];
		int count = 0;
		int[] ax = new int[3];
		int[] ay = new int[3];
		
		for (int j = 0; j < M; j++) {
			if (mat[N][j] == 1)
				arc[count++] = j;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

			}
		}

	}

	public static void dist(Point a, Point m) {// 아처좌표 , 몬스터좌표

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		matrix = new int[N + 1][M]; // N 행은 성임
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		func(0, 0);

	}
}
