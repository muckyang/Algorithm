package com.ssafy.edu.ws;
import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int [] s_count = new int [101];
		int Most_fren;
        int count;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            count  = sc.nextInt();
            int num;
			for(int i = 0 ; i < 1000;i++){
            	s_count[sc.nextInt()]++;
            }
			
           	Most_fren=0;
            for(int i = 100; i > 0 ; i--){
            	if(s_count[Most_fren] < s_count[i])
                    Most_fren = i;
            }
		

            System.out.println("#" + test_case + " " + Most_fren );
            s_count = new int [101];
		}
	}
}
