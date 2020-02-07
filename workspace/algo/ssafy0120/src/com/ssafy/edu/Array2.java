package com.ssafy.edu;

public class Array2 {
	
	public static void main(String[] args) {
		
		int [][]a = new int[3][2]; // 배열 초기화 안했으니 0 으로 초기화
		
		int [][]b = new int[][] { {1,2}, {2,3}, {3,4} }; // 강제초기화
		System.out.println("b.length    : " + b.length);
		System.out.println("b[0].length : " + b[0].length);
		System.out.println("b           : " + b);
		System.out.println("b[0]        : " + b[0] );
		System.out.println("b[0][0]     : " + b[0][0]);
		
		int [] c = {1,2,3,4,5};
		for(int i=0; i<c.length; i++) {
			System.out.print(c[i] + " ");
			//c[i] = -4
		}

		System.out.println();
		
		
		// 자동으로  length 계산해서 처음부터 끝까지 반복함 
		for(int auto : c) { //auto에 값이 직접 들어가기에 c[auto]로 작성하지 않는다. 
			System.out.print(auto + " ");
			// 보통 출력용으로 사용하고 값 변경하는데는 쓰지않음
		}
		System.out.println();
		System.out.println();
		
		System.out.println("<2차원배열>");		
		for(int i = 0; i < b.length; i++) {
			for(int j=0 ;j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		 
	}
}
