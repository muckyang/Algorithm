package Ing;
import java.util.Scanner;

public class Main_2567_색종이2_어케하냐 {
	static int T, N;
	static int [][] matrix;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, 0, -1, 0, -1, 1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		T = sc.nextInt();
		N = sc.nextInt();
		int count = 0;
		matrix = new int[101][100];
		visited = new boolean[101][100];
		int x, y;
		for (int t = 0; t < N; t++) {
			x = sc.nextInt();
			y = sc.nextInt();

			for (int i = x + 1; i <= x + 9; i++) {
				for (int j = y + 1; j <= y + 9; j++) {
					matrix[i][j] = t;//이렇게하면 덮어 씌워짐.. 
				}
			}

		}

		System.out.println(count);

	}
}
