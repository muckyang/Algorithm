package com.ssafy.edu;

public class B_BubbleSort {
	public static void main(String[] args) {
		int [] b = {2,6,4,3,5,9,8,1,7};
		
		for (int p : b) {
			System.out.print(p + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < b.length-1; i++) {
			for (int j = 0; j < b.length-1-i; j++) {
				
				if( b[j] < b[j+1] ) {
					int temp = b[j];
					b[j] = b[j+1];
					b[j+1] = temp;			
				}
			}
		}
		
		for (int p : b) {
			System.out.print(p + " ");
		}
		
		System.out.println();
		
	}
}
