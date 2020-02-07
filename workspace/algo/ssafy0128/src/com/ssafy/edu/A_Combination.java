package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class A_Combination {
	static int [] num;
	static int it; //조합이 가능한 갯수 
	static int N, C;
	
	public static void combination(int n , int r, int start, int count) {
		//5 C 3 = 3회 연산
		
		if(count == r) {
			it++;
			System.out.println(Arrays.toString(num));//조합의 모든 쌍 출력
			return;
		}else {
			for(int i = start; i < n; i++) {
				num[count] = i + 1;
				combination(n, r, i + 1, count + 1);
			}
		}		
		return ;		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		it = 0;
		
		N = sc.nextInt();
		C = sc.nextInt();
		
		
		num = new int [C];
		combination(N, C, 0, 0);
		System.out.println(it);
		
	
	}

}
