package Algo01_Week3;

public class Solution_도둑질 {

	public static void main(String[] args) {
		int[] money = { 1, 2, 3, 1,5};
		System.out.println(solution(money));
	}

	static int cache[][];
	static int don[];

	public static int solution(int[] money) {
		int res = 0;
		don = money.clone();
		cache = new int[2][money.length];
		res = solve(0, 0, money[0]);// 0 선택
		res =Math.max(res, solve(1, 1, money[1]));// 1선택
		return res;
	}

	private static int solve(int st, int num, int sum) {
		if (num >= don.length)
			return sum;
		if (st == 0 && num == don.length - 1)
			return 0;
		if (cache[st][num] != 0)
			return cache[st][num];
		int max = sum;
		
		if (num + 2 < don.length)
			max = Math.max(max, solve(st, num + 2, sum + don[num + 2]));
		if (num + 3 < don.length)
			max = Math.max(max, solve(st, num + 3, sum + don[num + 3]));
		return cache[st][num] = max;
	}

}
