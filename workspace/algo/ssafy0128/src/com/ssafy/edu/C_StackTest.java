package com.ssafy.edu;

import java.util.Stack;

public class C_StackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(3);
		stack.push(5);
		stack.push(8);
	
		//스택은 들어온 역순으로 출력
		while(!stack.isEmpty()) {
			//삭제하면서 리턴
			int pp = stack.pop();
			System.out.println(pp);
		}
		
		
	}
}
