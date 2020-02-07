package ssafy0203;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_제로 {
	static int T,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack <Integer> stack = new Stack<>();
		T = sc.nextInt();
		int su;
	
		for(int test_case = 1 ; test_case <= T; test_case++) {
			int sum = 0;
			K = sc.nextInt();
			for(int i = 0; i < K ; i++) {
				su =sc.nextInt();
				if(su == 0) {
					stack.pop();
				}else {
					stack.push(su);
				}
			}
			
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			System.out.println("#" + test_case + " "+sum);
		}
	}
}
