package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {
		
	static int [][] ladder_list;
	static int [] dy= {0,0,-1};
	static int [] dx= {1,-1,0};
	
	static int func(int [][] list,int i, int j) {
		while(true) {
			if(i == 1)
				return j-1;
			
			else if(j == 100 && list[i][j-1] == 0) {
				i--;
			}else if(j == 1 && list[i][j+1] == 0) {
				i--;
			}else if(j == 100 && list[i][j-1] == 1 ) {
				while(true) {
					j--;
					if(list[i][j-1]==0) {
						i--;
						break;
					}
				}
			}else if(j == 1 && list[i][j+1] == 1 ) {
				while(true) {
					j++;
					if(list[i][j+1]==0) {
						i--;
						break;
					}
				}
			}else if(list[i][j-1] == 1) {
				while(true) {
					j--;
					if(list[i][j-1]==0) {
						i--;
						break;
					}
				}
			}else if(list[i][j+1]==1) {
				while(true) {
					j++;
					if(list[i][j+1]==0 ) {
						i--;
						break;
					}
				}
			}else if(list[i][j+1] == 0 && list[i][j-1] == 0) {
				i--;
			}
		}
	}
	

	public static void main(String[] args) {
		
		Scanner sc=  new Scanner(System.in);
		
		int T; 
		T = sc.nextInt();
		int target_i = 0,target_j = 0;
		
		for(int test_case = 1 ; test_case <= 10 ; test_case++) {
			ladder_list = new int [102][102];
			
			for(int i = 1; i < 101;i++) {
				for(int j = 1 ; j < 101;j++) {
					ladder_list[i][j] = sc.nextInt();
					if(ladder_list[i][j] == 2) {
						target_i = i;
						target_j = j;
					}
				}
			}
			int result = func(ladder_list,target_i , target_j)  ;
			System.out.println("#"+test_case+" "+ result);
		}	
	}
}

