package com.ssafy.java;

public class StringTest3 {
	public static void main(String[] args) {
		String str = "Hello Ssafy !!!";
		
		char c = str.charAt(4);
		System.out.println(c);
		System.out.println(str);
		System.out.println(str.concat(" @@@@"));
		//문자열은 고정이기에 concat해도 변하지않는다
		System.out.println(str);
		
		if(str.contains("Ss"))
			System.out.println(str + "은 Ss를 포함!");
		
		
		System.out.println("He로 시작하냐?" + str.startsWith("He"));
		System.out.println("He로 시작하냐?" + str.endsWith("@@@"));
		
		String s1 = "sSAfy";
		String s2 = "SsaFY";
		
		if(s1.equals(s2))
			System.out.println(s1 + "과" +s2 +"는 동일한 문자열이다" );
		if(s1.toLowerCase().equals(s2.toLowerCase()))
			System.out.println(s1 + "과" +s2 +"는 대소문자 구분하지않으면 동일한 문자열이다" );
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "과" +s2 +"는 대소문자 구분하지않으면 동일한 문자열이다" );
	}
}
