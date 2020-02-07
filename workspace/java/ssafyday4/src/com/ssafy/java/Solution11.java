package com.ssafy.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution11 {
	static int T, N;
	static int Answer;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Solution11.txt")));
		
		int T = sc.nextInt();
		//int T = Integer.parseInt(br.read()); 
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			char[][] map=new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.next().charAt(0);
					
				}
			}
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}