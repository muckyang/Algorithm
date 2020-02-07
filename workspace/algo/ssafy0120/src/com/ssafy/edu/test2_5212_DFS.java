package com.ssafy.edu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
//햄버거
public class test2_5212_DFS {

	public static int DFS(int k , int [][] m , int list_max, int now_cal, int max_cal , int now_score){
     	int max_f_score = now_score;
     	if(k >= list_max) //배열 최대도달
     		return now_score;

     	else {
     		for(int j = k+1; j < list_max; j++) {
     			if(max_cal >= now_cal + m[1][j]) {
     				max_f_score = Math.max(max_f_score, DFS(j, m,list_max,now_cal+m[1][j],max_cal,now_score + m[0][j])) ;
     			}
     		}
     	}

     	return max_f_score;
     }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		int num;//항목수
	    int	MAX_CAL;// 최대 칼로리
        int [][]score_cal=  new int[2][100];
      
        T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            num=sc.nextInt();
            MAX_CAL=sc.nextInt();
            
            for(int i= 0; i<num;i++){
            	score_cal[0][i] = sc.nextInt(); // 스코어
            	score_cal[1][i] = sc.nextInt(); // 칼로리
            }
            
            int max_score = 0;
            for(int i = 0 ; i < num ; i++) {
            	max_score = Math.max(max_score,DFS(i, score_cal,num,score_cal[1][i],MAX_CAL,score_cal[0][i]));
            }
            System.out.println("#"+ test_case + " " +max_score);
            
		}
    }
}