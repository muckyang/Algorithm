package Study_0215;

import java.util.Scanner;

public class Solution_D4_4111_무선단속카메라 {
	static int T, N, K;
	static int[] Camera;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T= sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			min = Integer.MAX_VALUE;
			Camera = new int [N];
			for(int i = 0 ; i < N; i++) {
				Camera[i] = sc.nextInt();
			}
			//받기 끝
		}
	}
}
