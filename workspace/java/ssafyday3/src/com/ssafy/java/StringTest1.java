package com.ssafy.java;

public class StringTest1 {
	public static void main(String[] args) {
		String s1 = "ssafy";
		String s2 = "ssafy";
		String s3 = new String("ssafy");
		String s4 = new String("ssafy");
		
		if(s1 == s2)
			System.out.println("s1 와 s2는 주소값이 같다");
		if(s1 == s3)
			System.out.println("s1 와 s3는 주소값이 같다");
		if(s1 == s4)
			System.out.println("s1 와 s4는 주소값이 같다");
		if(s2 == s3)
			System.out.println("s2 와 s3는 주소값이 같다");
		if(s2 == s4)
			System.out.println("s2 와 s4는 주소값이 같다");
		if(s3 == s4)
			System.out.println("s3 와 s4는 주소값이 같다");
		
		System.out.println("==========================================");
	
		if(s1.equals(s2))
			System.out.println("s1 와 s2는 값이 같다");
		if(s1.equals(s3))
			System.out.println("s1 와 s3는 값이 같다");
		if(s1.equals(s4))
			System.out.println("s1 와 s4는 값이 같다");
		if(s2.equals(s3))
			System.out.println("s2 와 s3는 값이 같다");
		if(s2.equals(s4))
			System.out.println("s2 와 s4는 값이 같다");
		if(s3.equals(s4))
			System.out.println("s3 와 s4는 값이 같다");
		
	}
}
