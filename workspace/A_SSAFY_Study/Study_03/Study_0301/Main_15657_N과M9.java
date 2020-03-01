
package Study_0301;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15657_N과M9 {
	static int N, R;
	static int[] list;
	static int[] check;
	static int[] cnt;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		list = new int[N];
		check = new int[R];
		cnt = new int[10001];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
			cnt[list[i]]++;
		}
		Arrays.sort(list);

		perm(0);
		System.out.print(sb);
	}

	private static void perm(int count) {

		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(check[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (cnt[list[i]] > 0) {
				check[count] = list[i];
				cnt[list[i]]--;
				perm(count + 1);
				cnt[list[i]]++;
			}
		}

	}
}
