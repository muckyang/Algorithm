package com.ssafy.edu;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기_ {
	static Stack<Character> stack = new Stack<>();
	
	public static boolean is_Open(char c) {
		if(c == '{'  || c == '[' || c =='(' || c =='<') {
			return true;
		}
		return false;
			
	}
	public static boolean is_Complete(char c) {
		if(c=='}' && stack.pop() == '{' ) {
			return true;
		}else if(c==')' && stack.pop() == '(' ) {
			return true;
		}else if(c=='>' && stack.pop() == '<' ) {
			return true;
		}else if(c==']' && stack.pop() == '[' ) {
			return true;
		}else 
			return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N;
		String S;
		int result = 1;
		for(int test_case = 1; test_case <= 10; test_case++) {
			result = 1;
			N = sc.nextInt();
			S = sc.next();
			for(int i = 0 ; i < N ; i++) {
				if(is_Open(S.charAt(i))) {
					stack.add(S.charAt(i));
				}else {
					if(!is_Complete(S.charAt(i))) {
						result = 0;
						break;
					}
				}
			}
			
			//+++다 돌았는데 스택에 남아있음
			if(!stack.isEmpty()) {
				result = 0;
			}
			System.out.println("#" + test_case + " " + result);
		}
		
	}

}
