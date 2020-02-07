package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_1859 {
	//증가하면 더함
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		int [] cost;
		long cost_Sum;
		int mc;
		for(int test_case = 1; test_case <= T; test_case++) {
			mc = 0;
			cost_Sum = 0;
			N = sc.nextInt();
			cost = new int[N]; //  배열에 담는다? 
			for(int i = 0; i < N ; i ++) {
				cost[i] = sc.nextInt();
			}
			
			for (int i = N-1; i >= 0; i--) {
				if(mc > cost[i]) {
					if( i == N ) {
						mc = cost[i];
						break;
					}
					cost_Sum += (mc - cost[i]);
				}else{
					mc = cost[i];
				}
			}
			System.out.println("#" + test_case + " " + cost_Sum);
		}
		
	}

}
