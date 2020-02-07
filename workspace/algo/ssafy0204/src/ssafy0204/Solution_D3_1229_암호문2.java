package ssafy0204;

import java.awt.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_1229_암호문2 {
	static int T;// dummy
	static int N, C;
	static int sp;
	static int count;
	static String c_Type;
	static LinkedList<Integer> link;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case < 11; test_case++) {
			link = new LinkedList<>();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				link.add(sc.nextInt());
			}
			
			C = sc.nextInt();

			for (int i = 0; i < C; i++) {
				c_Type = sc.next();
				sp = sc.nextInt();
				count = sc.nextInt();
				if (c_Type.contentEquals("I")) {
					for (int j = 0; j < count; j++) {
						link.add(sp + j, sc.nextInt());
					}
				} else {
					for (int j = 0; j < count; j++)
						link.remove(sp);
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(link.get(i) + " ");
			}
			System.out.println();
		}
	}
}
