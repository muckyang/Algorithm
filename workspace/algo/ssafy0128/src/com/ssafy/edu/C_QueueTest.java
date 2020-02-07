package com.ssafy.edu;

import java.util.LinkedList;
import java.util.Queue;

public class C_QueueTest {

	public static void main(String[] args) {
		Queue<Integer> ques = new LinkedList<>();
		
		ques.offer(1);
		ques.offer(4);
		ques.offer(5);
		ques.offer(7);
		
		while (!ques.isEmpty()) {
			//poll 가장 아래에 있는것을 삭제하면서 리턴
			int qq =ques.poll(); // peek -> gets
			System.out.println(qq);
			
			
		}
		
	}

}
