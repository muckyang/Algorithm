package com.ssafy.java;

public class StringTest2 {
	public static void main(String[] args) {
		String s1 = new String();
		System.out.println(s1.length());
		if(s1.length() == 0 )
			System.out.println("s1 은 비어있습니다.");
		if(s1.isEmpty())
			System.out.println("s1 은 비어있습니다.");
		byte [] b = {97,98,99,100,101,102,103,104};
		//byte [] b = {-20,-117,-72,-127,-67,-57};
		
		String s2 = new String(b);
		
		System.out.println(s2);
		
		String s3 = new String(b,2,4);
		
		System.out.println("s3 = " +s3);
		
		char [] c = {'S' ,'s' ,'a' ,'f' ,'y'};

		String s4 = new String(c);
		System.out.println("s4 =" + s4);
	

		String s5 = new String(c,1,3); // 1위치부터 3개
		System.out.println("s5 =" + s5);
	
		
	}
}
