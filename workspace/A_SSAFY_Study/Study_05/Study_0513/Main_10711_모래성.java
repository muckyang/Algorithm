package Study_0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10711_모래성 {
	static int N, M;
	static int map[][];
	static int dx[] = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int dy[] = { 1, 0, -1, 0, -1, 1, 1, -1 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '.')
					map[i][j] = 0;
				else
					map[i][j] = Integer.parseInt(c + "");
			}
		}

//		print();
		solve();

	}

	private static void solve() {
		
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
