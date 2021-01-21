package TODO;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution_외벽점검 {

	static int res;
	static boolean wall[];
	static boolean[] temp;

	public static void main(String[] args) {
		int[] answer = { 1, 2, 3, 4, 5 };
		int[] res = solution(answer);
	}

	public static int[] solution(int[] answer) {
		int[] res = null;
		int[] su = { 5, 8, 10 };
		int[][] student = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] cnt = new int[3];
		LinkedList<Integer> list=new LinkedList<>();
		int max = 0;
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < 3; j++) {
				int dap = i % su[j];
				if (answer[i] == student[j][dap]) {
					cnt[j]++;
					max = Math.max(cnt[j], max);
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (max == cnt[i])
				list.add(i);
		}
		Collections.sort(list);
		res = new int[list.size()];
		int c = 0;
		for(int k : list) {
			res[c++] =k;
		}
			
		return res;
	}

}
