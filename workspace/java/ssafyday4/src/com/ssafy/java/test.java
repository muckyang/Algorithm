package com.ssafy.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	static int [] dx = {1, -1,0,0};//수직이동
	static int [] dy = {0, 0,1,-1};
	static int move;
	static int [][] matrix;
	static int N;
	
	public static int trans(String c) {
		switch(c) {
			case "S":
				return 0;
			case "W":
				return 1;
			case "A":
				return 2;
			case "B":
				return 3;
			case "C":
				return 4;
				
		}
		return -1;
	}
	
	public static void func(int K,int y,int x) {
		int xl,yl;
		if(K==2) {//A로봇
			while(x+dx[0] < N && matrix[y][x+dx[0]] == 0) {
				move++;
				x+=dx[0];
				y+=dy[0];
			}
		}else if(K==3) {//B로봇
			for(int i = 0; i < 2; i++) {
				xl = x;
				yl = y;
				while(xl + dx[i] < N && xl+dx[i] >= 0 && matrix[yl+dy[i]][xl+dx[i]] == 0) {
					move++;
					xl+=dx[i];
					yl+=dy[i];
				}
			}
		}else { // C로봇
			for(int i = 0; i < 4; i++) {
				xl = x;
				yl = y;
				while(xl +dx[i] < N && xl+dx[i] >= 0 && yl +dy[i] < N && yl+dy[i] >= 0  && matrix[yl+dy[i]][xl+dx[i]] == 0) {
					move++;
					xl+=dx[i];
					yl+=dy[i];
				}
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		
		String d;
		T= sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {	
			move =0 ;
			N = sc.nextInt();
			matrix = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					matrix[i][j]=trans(sc.next());
				}
			}
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(matrix[i][j] < 2 )
						continue;
					else { 
						func(matrix[i][j],i,j);
					}
				}
			}
			System.out.println("#" + test_case + " " + move);
		}
	}
}
