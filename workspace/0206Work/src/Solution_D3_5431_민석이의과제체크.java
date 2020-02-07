import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_5431_민석이의과제체크 {
	static void func() {
		for(int i = 0 ; i < N; i++) {
			ll.add(i);
		}
	}

	static LinkedList <Integer> ll ;
	static int T, N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			ll = new LinkedList<>();
			for(int i = 0 ; i < M ; i++)
				sc.nextInt();
			func();
		

			System.out.println("#" + test_case + " " + ll);
			
		}
	}
}
