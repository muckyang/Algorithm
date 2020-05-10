package KAKAO;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
// 2020. 5. 10 개 꼬라박고 겨우 풀어놓음 
public class Solution2 {
	static List<Long> slist;
	static List<Character> clist;

	static long su[];
	static int yeon[];
	static Character ch[];
	static long result;

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
//		String expression = "50*6-3*2";
		su = new long[100];
		yeon = new int[3];// - ,+,*
		ch = new Character[100];
		String s = "";
		clist = new LinkedList<>();
		slist = new LinkedList<>();
		result = 0L;
		int count = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (0 <= expression.charAt(i) - '0' && expression.charAt(i) - '0' <= 9) {
				s += expression.charAt(i);
			} else {
				su[count] = Integer.parseInt(s);
				ch[count] = expression.charAt(i);
				count++;
				s = "";
			}
		}
		su[count] = Integer.parseInt(s);
		combi(0);
		System.out.println(result);
	}

	private static void combi(int cnt) {
		if (cnt == 3) {
			slist.add(su[0]);
			for (int i = 0; ch[i] != null; i++) {
				clist.add(ch[i]);
				slist.add(su[i+1]);
			}
			result = Math.max(result, Math.abs(solve()));
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (yeon[i] == 0) {
				yeon[i] = cnt + 1;
				combi(cnt + 1);
				yeon[i] = 0;
			}
		}
	}

	private static long solve() {
		for (int i = 3; i > 0; i--) {
			for (int k = 0; k < clist.size(); k++) {
				int cal = check(clist.get(k));
				if (cal == yeon[i-1]) {
					long number = calc(slist.remove(k), slist.remove(k), clist.remove(k));
					slist.add(k, number);
					k--;
				}
			}
		}
		return slist.remove(0);

	}

	private static long calc(long num1, long num2, Character c) {
		long num = 0;
		if (c == '-') {
			num = num1 - num2;
		} else if (c == '+') {
			num = num1 + num2;
		} else if (c == '*') {
			num = num1 * num2;
		}
		return num;
	}

	private static int check(Character peek) {
		if (peek == '-') {
			return 1;
		} else if (peek == '+') {
			return 2;
		} else if (peek == '*') {
			return 3;
		}
		return 0;
	}
}
