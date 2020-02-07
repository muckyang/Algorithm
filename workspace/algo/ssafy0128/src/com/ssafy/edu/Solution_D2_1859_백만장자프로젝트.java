/** 교수님 코드*/

package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {

	public static void print(int [] mm){
		for (int i = 0; i < mm.length; i++) {
			System.out.print(mm[i] + " ");
		}
		System.out.println();
	}
	
	
	static int T;
	static int N;
	static int [] oneh;
	static long sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//filter(node) 호스 (수도꼭지)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = null;
		
		//st = new StringTokenizer(br.readLine());// checked Execption
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			sum = 0L;// 뒤에  long타입인 것을 명시해줌
			N = Integer.parseInt(br.readLine()); //Rapper class
						//줄 단위로 읽은 것을 띄어쓰기 단위로 쪼갬
			st = new StringTokenizer(br.readLine());// checked Execption 
			oneh = new int[N];
			
			for (int i = 0; i < N; i++) {
				oneh[i] = Integer.parseInt(st.nextToken().trim());
			}
//			print(oneh);
		
		}
		
	}

}
