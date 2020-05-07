package Study_0506;

import java.util.Scanner;

public class Main_6987_월드컵_미완성 {
	static int wdl[][];
	static boolean res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			wdl = new int[6][3];
			res = false;
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					wdl[j][k] = sc.nextInt();
				}
			}
			wperm(0, 0);
			if (res) {
				res = false;
				dperm(0, 0);
				if (res) {
					for (int a = 0; a < 6; a++) {
						for (int b = 0; b < 3; b++) {
							if (wdl[a][b] != 0)
								res = false;
						}
					}
				}
			}
			System.out.print(res ? 1 + " " : 0 + " ");
		}

	}

	private static void dperm(int start, int num) {
		if (num == 6) {
			res = true;
			return;
		}
		if (wdl[num][1] == 0) {
			dperm(0, num + 1);
			return;
		}
		for (int i = start; i < 6; i++) {
			if (wdl[num][1] > 0 && wdl[i][1] > 0 && num != i) {
				wdl[i][1]--;
				wdl[num][1]--;

				dperm(i + 1, num);
				if (res)
					return;
				wdl[i][1]++;
				wdl[num][1]++;
			}
		}
	}

	private static void wperm(int start, int num) {
		if (num == 6) {
			res = true;
			return;
		}
		if (wdl[num][0] == 0) {
			wperm(0, num + 1);
			return;
		}
		for (int i = start; i < 6; i++) {
			if (wdl[num][0] > 0 && wdl[i][2] > 0 && num != i) {
				wdl[i][2]--;
				wdl[num][0]--;
				wperm(i + 1, num);
				if (res)
					return;
				wdl[i][2]++;
				wdl[num][0]++;
			}
		}
	}
}
