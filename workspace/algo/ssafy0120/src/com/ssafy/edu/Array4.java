package com.ssafy.edu;

import java.util.Arrays;

public class Array4 {
	public static void main(String[] args) {
		int [] data = {7,4,2,0,0,6,0,7,0};
		
		for (int i = 0 ; i < data.length; i++) {
			System.out.print(data[i] + " ");
			
		}
		System.out.println();
		
		Arrays.sort(data);
		//Arrays.parallelSort(data); //정리할 양 많은 경우에 사용됨
	
		for (int i = 0 ; i < data.length; i++) {
			System.out.print(data[i] + " ");
			
		}
		
		System.out.println();
	}
}
