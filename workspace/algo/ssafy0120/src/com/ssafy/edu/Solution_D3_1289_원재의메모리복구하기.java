package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T= sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			int start = s.indexOf('1'); // 없다면 -1.
			int count = 0;
			if(start != -1) {
				count = 1;
				for(int i = start; i < s.length()-1; i++) {
					if(s.charAt(i) != s.charAt(i+1)) {
						count++;
					}
				}
			}	
			System.out.println("#" + test_case + " " + count);
		}
	}
}
