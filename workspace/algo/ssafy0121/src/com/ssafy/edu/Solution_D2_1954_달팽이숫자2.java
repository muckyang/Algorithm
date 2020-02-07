package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자2 {
	static int T;
	static int N;
	static int[][] snail;
	
	
	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			T= sc.nextInt();
			
			for(int test_case = 1; test_case <= T; test_case++) {
				N = sc.nextInt();
				snail = new int[N][N];
				
				int d= 0;
				int y= 0;
				int x= 0;
				
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						snail[y][x] = i*N+j+1;
						
						if(d == 0) {
							if( !(x+dx[d] < N  && snail[y + dy[d]][x + dx[d]] == 0) ){ //0이면서  경계를 넘지 않는 경우
								d = 1;
							}	
							x+=dx[d];
							y+=dy[d];
						}else if(d == 1) {
							if( !(y+dy[d] < N  && snail[y + dy[d]][x + dx[d]] == 0) ){ //0이면서  경계를 넘지 않는 경우
								d = 2; //  왼쪽방향
							}else {
								
								x+=dx[d];
								y+=dy[d];
							}						
						}if(d == 2) {
							if( !(x+dx[d] >= 0  && snail[y + dy[d]][x + dx[d]] == 0 )){ //0이면서  경계를 넘지 않는 경우
								d = 3; // 아래 방향
								
							}else {
								x+=dx[d];
								y+=dy[d];
							
							}						
						}if(d == 3) {
							if( !(y+dy[d] >= 0  && snail[y + dy[d]][x + dx[d]] == 0) ){ //0이면서  경계를 넘지 않는 경우
								d = 0; // 아래 방향
							}
							x+=dx[d];
							y+=dy[d];
						}
					}
				}
	
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						System.out.print(snail[i][j] + " ");
					}
					System.out.println();
				}
	
				System.out.println();
				
			}
			
		

	}

}
