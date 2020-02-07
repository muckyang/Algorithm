package com.ssafy.java;

public class String_For_Algorithm {
	public static void main(String[] args) {
		String numstr = "123";
		System.out.println(numstr + 100);
		//문자열 -> 숫자
		int num = Integer.parseInt(numstr);
		System.out.println(num +100);
		System.out.println(1.0 * num +100);
		
		//숫자  -> 문자열
		String sn1 = ""+num;
		System.out.println(sn1 +100);
		
		String sn2 = String.valueOf(num);
		System.out.println(sn2 +100);
		
		String sn3 = Integer.toString(num);
		System.out.println(sn3 +100);

		
		
	}
}
