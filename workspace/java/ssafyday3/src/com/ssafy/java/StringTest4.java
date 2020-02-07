package com.ssafy.java;

public class StringTest4 {
	public static void main(String[] args) {
		String str = "hello ssapy java edu";
		// String str = "안녕 싸피";

		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "\t");
		}
		
		System.out.println();

		System.out.println(str + "에서 a 위치 : " + str.indexOf('a'));
		System.out.println(str + "에서 a 위치 : " + str.indexOf('a', 9));
		System.out.println(str + "에서 마지막 a 위치 : " + str.lastIndexOf('a'));

		System.out.println(str + "에서 java 위치 : " + str.indexOf("java"));

		System.out.println(str.replace('p', 'f'));
		System.out.println(str.replace("ssapy", "싸피"));

		String[] s = str.split("a");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}

		System.out.println(str.substring(6));
		System.out.println(str.substring(6, 11));

		

		char []c = str.toCharArray();
		for(int i = 0 ; i < c.length ; i++) {
			System.out.print(c[i] + "\t");
		}
		System.out.println();
		
		String s2 = "   hello   ssafy    ";
		System.out.println(s2 + "의 길이 : " + s2.length());
		System.out.println(s2.trim() + "의 길이 : " + s2.trim().length());
		
		
		String rev = "!!! yfass olleh";
		String rev_c="";
		for(int i = rev.length()-1 ; i >= 0 ; i--) {
			rev_c = rev_c + rev.charAt(i);
		}
		System.out.println(rev_c);
		System.out.println(rev_c + "에서 o는 " + rev_c.indexOf('o') + "번째에 있습니다.");
		
		
		
	}
}
