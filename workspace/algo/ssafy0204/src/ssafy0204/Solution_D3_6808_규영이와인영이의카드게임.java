package ssafy0204;

import java.util.Scanner;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static int T;
	static int[] Gyu;
	static int[] In;
	static int g_c, i_c;
	static int list[];
	public static void func(int count, int flag, int g_sum, int i_sum) {
		if (count == 9) {
			if (g_sum > i_sum) {
				g_c++;
			}
			if (g_sum < i_sum) {
				i_c++;
			}
		} else {
			for (int i = 0; i < 9; i++) {
				if ((flag & (1 << i)) == 0) {
					int chai = Gyu[count] - In[i];
					if (chai > 0) {// 규 이김
						func(count + 1, (flag | (1<<i)), g_sum + Gyu[count] + In[i], i_sum);
					} else {
						func(count + 1, (flag | (1<<i)), g_sum, i_sum + Gyu[count] + In[i]);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Gyu = new int[9];
			In = new int[9];
			list = new int[19];
			g_c = i_c = 0;
	
			for (int i = 0; i < 9; i++) {
				Gyu[i] = sc.nextInt();
				list[Gyu[i]] = 1;
			}
			
			int c = 0;
			for (int i = 1; i < 19; i++) {
				
				if (list[i] == 0) {
					In[c++] = i;

				}
			}
			/// 지정완료 규영이는 순서대로

			func(0, 0, 0, 0);
			System.out.println("#" + test_case + " " + g_c + " " + i_c);
		}
	}
}
