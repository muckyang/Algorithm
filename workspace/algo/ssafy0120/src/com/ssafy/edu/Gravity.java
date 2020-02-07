package com.ssafy.edu;

import java.util.Scanner;

public class Gravity {
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); // 생성할 블록사이즈 
		max = 0;
		
		int[][] array = new int[size][size];		//회전된 상자 배치할 배열
		int[][] result = new int[size][size];		//각 상자가 몇칸씩 내려갈 수 있는지 저장하는 배열
		int[] length = new int[size];				//회전된 배열의 각 행 길이 (회전전의 높이)
		
		
		for(int i = 0; i < size; i++) {
			int n = sc.nextInt(); 
			length[i] = n; // 높이가 곧 길이로 변함
			//행을 열로 변환시킴
			for(int j = 0 ; j < n; j++) {
				array[i][j] = 1;				//상자가 있는 부분은 1로 저장
			}
		}
		// 가장 아래에 있는 상자열 부터 낙하 시킨다. 
		for(int i = size-1; i >= 0; i--) {
			for(int j = 0 ; j < length[i]; j++) {
				go(array,length,i,j,result);		//한 상자에 대해서 낙차계산
			}
		}
		System.out.println(max);
	}
	
	public static void go(int[][] array, int[] length, int y_index, int index,int[][] result) {
		int size = array.length;
		for(int j = y_index + 1; j < size; j++) {		//상자 밑칸부터 탐색
			if(array[j][index] != 0) {				//상자가 있다면
				result[y_index][index] = j-y_index-1 + result[j][index];	//자신의 위치와 아래 상자의 위치의 차 + 아래상자가 얼마나 내려갈 수 있는지
				break;
			}
			else if(j == size-1) {					//아무 상자도 못만났다면
				result[y_index][index] = j-y_index;	//맨 아래까지 내려가기 때문에 size-1 - y_index
			}
		}
		//이 상자의 낙차가 최대 값이면 갱신
		max = max > result[y_index][index] ? max : result[y_index][index];	}
}
