package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("키와 몸무게를 순서대로 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		
		int height;
		int weight;
		height = sc.nextInt();
		weight = sc.nextInt();
		System.out.printf("비만수치는 %d입니다.\n",weight+100 -height);
		
		if( (weight+100 -height) > 0)
			System.out.println("당신은 비만이군요");
	}

}
