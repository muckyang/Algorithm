package ssafy0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution_D4_7701_염라대왕의이름정렬 {
	static int T, N;
//	static Set<String> s;
//	static TreeSet<String>[] ts; // 트리셋배열

	public static class OHC implements Comparator<String> {
		// 길이 확인후 사전식 정렬
		@Override
		public int compare(String o1, String o2) {
			if (o1.length() > o2.length()) {
				return 1;
			} else if (o1.length() < o2.length()) {
				return -1;
			} else {
				return o1.compareTo(o2);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		// Scanner sc = new Scanner(System.in);
		// T = sc.nextInt();
		TreeSet<String> ts = new TreeSet<>();
		LinkedList<String> names = new LinkedList<>();

		for (int test_case = 1; test_case <= T; test_case++) {
			// N = sc.nextInt();
			N = Integer.parseInt(br.readLine());// runtime 에러
			ts.clear();
			names.clear();
			for (int i = 0; i < N; i++) {
				String name = br.readLine();
				ts.add(name);// 중복 제거하면서 TreeSet에 추가
			}
			for (Iterator<String> it = ts.iterator(); it.hasNext();) {
				names.add(it.next());

			}

			names.sort(new OHC());

			System.out.println("#" + test_case);
			for (String s : names) {
				System.out.println(s);
			}
		}
	}
}
