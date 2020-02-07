package Study_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_1868_파핑파핑지뢰찾기_DFS {
	static char[][] mine; // *, . 입력받음
	static int[][] matrix; // 지뢰 : -1 , 주변지뢰 : 1 , 안전구역 : 0

	static boolean[][] visited; // 안전구역 지나쳤는지 확인
	static int[] dx = { 0, 1, 0, -1, 1, -1, -1, 1 };
	static int[] dy = { -1, 0, 1, 0, -1, -1, 1, 1 };

	static int T;
	static int N;
	static int count;

	public static int check_8Way(int x, int y, int check) {

		if (check == 1) {// 8 방향에 지뢰가 있는 경우 값을 1로 만듬
			for (int d = 0; d < 8; d++) {
				if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N
						&& mine[x + dx[d]][y + dy[d]] == '*') {
					return 1;
				}
			}
		} else {
			for (int d = 0; d < 8; d++) {// 8방에 0 이 있으면
				if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N
						&& mine[x + dx[d]][y + dy[d]] == '.') {
					return 1;
				}
			}
		}
		// 주변에 0 or 지뢰 없는경우
		return 0;
	}

	public static void DFS(int x, int y) { // DFS 인접한 안전구역 체크
		for (int d = 0; d < 8; d++) {
			if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N && matrix[x + dx[d]][y + dy[d]] == 0
					&& visited[x + dx[d]][y + dy[d]] == false) {
				visited[x + dx[d]][y + dy[d]] = true;
				DFS(x + dx[d], y + dy[d]);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			mine = new char[N][N];
			matrix = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) { // 지뢰 입력받음
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					mine[i][j] = s.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mine[i][j] == '*') { // 지뢰라면 -1
						matrix[i][j] = -1;
					} else if (mine[i][j] == '.' && check_8Way(i, j, 1) > 0) { // '.'의 주변에 지뢰 있으면 1
						matrix[i][j] = 1;
						count++;// '.' 주변에 지뢰있는것 모두세어줌
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(matrix[i][j] == 1 && check_8Way(i, j, 0) != 0) {
						count--;// '.'주변에 0이 하나라도 있으면 0클릭시 자동으로 열리므로 갯수에서 제외
					}
				}
			}

			// 인접한 안전구역 모두 visited = true
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == 0 && visited[i][j] == false) {
						count++;// 처음나온 0에서만 count++ (인접한 0은 카운트 세지않고 visited =true)
						visited[i][j] = true;
						DFS(i, j);
					}
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
