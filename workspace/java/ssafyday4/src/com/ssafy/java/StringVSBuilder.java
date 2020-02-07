package com.ssafy.java;

public class StringVSBuilder {
	public static void main(String[] args) {
		String str = "Hello";
		long st = System.nanoTime();
		for (int i = 0; i < 50000; i++) {
			str += " ssafy !!!";
			
		}
		System.out.println(System.nanoTime() - st);
		
		
		StringBuilder sb = new StringBuilder("Hello");
		long st2 = System.nanoTime();
		
		for (int i = 0; i < 50000; i++) {
			sb.append(" ssafy !!!");
			
		}
		System.out.println(System.nanoTime() - st2);
		
		System.out.println(str);
		System.out.println(sb);
		
	}
}
