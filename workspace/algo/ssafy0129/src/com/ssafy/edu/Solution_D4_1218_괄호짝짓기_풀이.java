package com.ssafy.edu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기_풀이 {
	static int T = 10;
	static int N;
	static String S;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			S = sc.next();
			char[] str = S.toCharArray();
			HashMap<Character, Character> map = new HashMap<>();// 제네릭으로 지정
			map.put('(', ')');
			map.put('[', ']');
			map.put('{', '}');
			map.put('<', '>');
			
			Stack<Character> stack = new Stack<>();
			boolean possible = true;

			for (int i = 0; i < N; i++) {
				if (map.containsKey(str[i])) {// map에 key 상태로 존재하는가?
					stack.push(str[i]);
				}else {
					if(!stack.isEmpty() && str[i] == map.get(stack.peek())){//peek은 pop과 다르게 빼내지않음
						stack.pop();
					}else {
						possible =false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) {// 다 돌았는데 아직 스택이 차있음
				possible = false;
			}
			
			if(possible)
				System.out.println("#" + test_case + " 1" );
			else
				System.out.println("#" + test_case + " 0" );
			
		}

	}

}
