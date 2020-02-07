package com.ssafy.edu;
//숫자의 연속된 갯수 출력 11 -> 1이 2개 12
public class A_Ant {
	public static void main(String[] args) {
		ant(20);
	}
	
	public static void ant(int stage) {
		String s="11";
		for (int i = 0; i < stage; i++) {
			System.out.println(s);
			s= ant(s);
		}
	}
	
	
	public static String ant(String s) {
		String t="";
		char c =s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if(c == s.charAt(i))
				count++;
			else {
				t = t+c+count;
				c = s.charAt(i);
				count = 1;
				
			}	
		}
		//마지막은 그냥 나와야 하므로 
		t=t+c+count;
		
		return t;
	}
}
