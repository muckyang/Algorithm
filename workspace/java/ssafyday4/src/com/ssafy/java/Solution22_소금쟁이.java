package com.ssafy.java;

import java.util.Scanner;

public class Solution22_소금쟁이 {
	static int T,N,M;
	static int [][] is_in;
	static int [] sx;
	static int [] sy;
	static int [] st;
	static int [] dx = {0,-1,1,0,0};
	static int [] dy = {0,0,0,-1,1};
	static int life;
	
	public static void jump(int x, int y, int t) {
		
		for(int i = 3 ; i > 0;i--) {
			if(is_in[x][y] == 1) {
				life--;
				return;
			}
			x= x + (dx[t] * i);
			y= y + (dy[t] * i);
			
		}
		if(is_in[x][y] == 1) {
			life--;
			return;
		}
		is_in[x][y] = 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			sx = new int[M];
			sy = new int[M];
			st = new int[M];
			
			life = M;
			is_in = new int [N][N];
			for(int i = 0; i < M ; i++) {
				sx[i]=sc.nextInt();
				sy[i]=sc.nextInt();
				st[i]=sc.nextInt();
			}
			for(int i = 0; i < M ; i++) {
				if( sx[i] + dx[st[i]] * 6 < 0 || sy[i] + dy[st[i]]* 6 < 0 || 
						sx[i] + dx[st[i]] * 6 > N-1 || sy[i] + dy[st[i]]* 6 > N-1 ) {
					life--;
					continue;
				}else {
					jump(sx[i],sy[i],st[i]);
				}
			}
			System.out.println("#" +test_case + " " +life);
		}
		
	}
}
