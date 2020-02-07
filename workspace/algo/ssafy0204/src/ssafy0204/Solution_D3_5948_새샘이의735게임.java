package ssafy0204;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution_D3_5948_새샘이의735게임 {
	static int T;
	static TreeSet<Integer> ts;
	static int[] list;
	static int[] m;

	public static void func(int N, int C, int start, int count) {
		if (count == C) {
			int sum = 0;
			for (int i = 0; i < C; i++) {
				sum += m[i];
			}

			if (ts.isEmpty()) {
				ts.add(sum);
			} else if (!ts.contains(sum))
				ts.add(sum);

			return;
		} else {
			for (int i = start; i < N; i++) {
				m[count] = list[i];
				func(N, C, i + 1, count + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			ts = new TreeSet<>();
			list = new int[7];
			m = new int[3];
			for (int i = 0; i < 7; i++) {
				list[i] = sc.nextInt();
			}

			func(7, 3, 0, 0);
			
			for (int i = 0; i < 4; i++)
				ts.pollLast();

			System.out.println("#" + test_case +" "+ts.pollLast());
//			ts.clear();
		}
	}

}
