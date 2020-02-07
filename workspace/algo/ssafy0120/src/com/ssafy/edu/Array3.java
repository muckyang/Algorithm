package com.ssafy.edu;

public class Array3 {
	public static void main(String[] args) {
		int [] data = {7,4,2,0,0,6,0,7,0};
		
		//역순출력
		for (int i = data.length -1 ; i >= 0 ; i--) {
			System.out.print(data[i] + " ");
			
		}
		
		System.out.println();
	}
}
