  package com.ssafy.edu;

public class A_Combination_Test3 {

	static int N = 5;
	static int R = 3;
	static char[] c;
	static int cnt;
	static boolean[] checked;

	public static void nCr(int start, int count) {
		if (count == R) {
			String as = "";
			String bs = "";
			
			for(int i = 0 ; i < checked.length; i++) {
				if(checked[i]) {
					as =as + c[i];
					
				}else {
					bs =bs + c[i];
					
				}
			}
			cnt++;
			System.out.println("checked   :"+as); 
			System.out.println("unchecked :"+bs); 
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {// i = start 대신 i = 1 로 하면 전체 경우의 수 출력

			if (!checked[i]) {
				checked[i] = true;
				nCr(i + 1, count + 1);
				checked[i] = false;
			}

		}
	}

	public static void main(String[] args) {
		cnt = 0;
		c = "ABCDE".toCharArray();
		checked = new boolean[N];// 기본타입 false로 되어있음!
		nCr(0, 0);
		System.out.println(cnt);
	}

}
