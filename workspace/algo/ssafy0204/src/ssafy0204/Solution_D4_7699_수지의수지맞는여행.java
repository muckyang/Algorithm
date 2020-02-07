package ssafy0204;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_D4_7699_수지의수지맞는여행 {

	static int T;
	static int R, C;
	static int sx, sy;
	static char[][] matrix;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static Set<Character> set;
	static int v_Max;

	public static void DFS(int x, int y) {
		int check = 0;
		
		if(set.size() > v_Max) {
		//	System.out.println(set);
			
			v_Max = set.size();
		}
		if (set.size() == 26) {
			v_Max = Math.max(v_Max, set.size());
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < R && y + dy[d] < C
					&& set.contains(matrix[x + dx[d]][y + dy[d]]) == false) {// set에 존재하지 않는경우
				set.add(matrix[x + dx[d]][y + dy[d]]);
				DFS(x + dx[d], y + dy[d]);
				set.remove(matrix[x + dx[d]][y + dy[d]]);
			}
		}
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			R = sc.nextInt();
			C = sc.nextInt();
			sx = sy = 0;
			v_Max = Integer.MIN_VALUE;
			set = new HashSet<>();
			matrix = new char[R][C];
			for (int i = 0; i < R; i++) {
				String s = sc.next();
				for (int j = 0; j < C; j++) {
					matrix[i][j] = s.charAt(j);
				}
			}
			// 인풋 끝

			set.add(matrix[0][0]);// 처음위치 set에 저장
			DFS(0, 0);

			System.out.println("#" + test_case + " " + v_Max);
		}

	}
}
