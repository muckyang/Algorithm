package com.ssafy.java;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StringBulider_Test {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("SSAFY");
		System.out.println(sb);
		System.out.println(sb.toString());
		
		System.out.println("1. 초기 크기 : " + sb.capacity());
		System.out.println("2. 초기 문자크기 : " + sb.length());
		
		sb.append(" !!!"); //  문자열에서 concat 했다면 변하지 않았을 것
		System.out.println(sb);
		System.out.println(sb.toString());
		System.out.println("3. 크기 : " + sb.capacity());
		System.out.println("4. 문자크기 : " + sb.length());
		sb.append(" !!!");
		sb.append(" @@@@");
		sb.append(" !!!");
		sb.append(" !!!");

		System.out.println("5. 크기 : " + sb.capacity());
		System.out.println("6. 문자크기 : " + sb.length());
		System.out.println(sb.delete(10, 17));
		System.out.println(sb.deleteCharAt(3));
		System.out.println(sb.insert(0, "HELLO "));
		System.out.println(sb.replace(6, 10 , "안녕"));
		
		String str = "!!! yfass olleh";
		System.out.println(str);
		StringBuilder sb2 = new StringBuilder(str);
		System.out.println(sb2.reverse());
		
	}

}
