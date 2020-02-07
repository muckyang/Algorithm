package com.java.first;
import java.util.Scanner;

public class Computer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.print("두 수를 입력하세요 : ");
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.printf("곱 = %d\n",a*b);
		System.out.printf("몫 = %d\n",a/b);
	}
}
