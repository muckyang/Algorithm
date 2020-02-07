package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_9229_한빈이의스팟마트 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N ,M;
		int [] weight;
		for(int test_case = 1 ; test_case <= T; test_case++) 		{
			
			int max = -1;
			
			N= sc.nextInt();
			M= sc.nextInt();
			weight  = new int [N];
			
			for(int i = 0; i<N;i++) {
				weight[i]= sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(weight[i] + weight[j] <= M && weight[i] + weight[j] > max)
							max = weight[i] + weight[j];
				}
			}
			System.out.println("#"+test_case + " " +max);
		}
		
		
	}

}
