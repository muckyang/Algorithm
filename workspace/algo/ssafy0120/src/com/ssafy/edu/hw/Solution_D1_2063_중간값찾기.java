package com.ssafy.edu.hw;
import java.util.Arrays;
import java.util.Scanner;
public class Solution_D1_2063_중간값찾기 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N;
		N=sc.nextInt();
		int [] array1 = new int[200];
        for(int i = 1; i < N; i++){
			array1[i] = sc.nextInt();
		}
        Arrays.sort(array1);
        System.out.println(array1[ N/2 + 1 ]);
        
	}

}
