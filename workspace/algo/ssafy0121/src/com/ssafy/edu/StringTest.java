package com.ssafy.edu;

public class StringTest {

	public static void main(String[] args) {
		String h = "hello";
		System.out.println(h);

		String a =h;
		a= "allo";
		System.out.println(h); // 얕은 복사로 인해 Hello 출력
	
		
		//String보다 빠르고 가비지컬렉션으로 정리되지 않음 
		StringBuffer sb = new StringBuffer();
		sb.append("HELLO");
		sb.append("go");
		System.out.println(sb.toString());
		
		StringBuffer sb2= sb;
		sb2.append("KILL");
		
		System.out.println(sb.toString());
		
		System.out.println(h.indexOf('l'));// 처음나오는  l 주소 리턴해줌
		System.out.println(h.lastIndexOf('l'));// 마지막 나오는  l 주소 리턴해줌
		
		String b= h.replace('H', 'g');// " " , "" 사이에 있는 공백제거 
		System.out.println(b);
		System.out.println(h);
		System.out.println(h.toLowerCase());
		h.concat(b); // + 연산
		
		

		System.out.println("SUBSTRING  : " + sb.substring(0,3));
		
		
		
		System.out.println(h.contains("el")); // 포함여부 판단

		System.out.println(h);
		//(사전식 정렬시)'h' - 'a' 양수면 h가 더 늦다, 음수면 h가 더 빠르다.
		System.out.println(h.compareTo("allo")); 	
		
		
		char[] cc = h.toCharArray();
		String hc = new String(cc);
	}
}


// jvm heaven(heap 내) ->    -> hell >>(시간)>>> 가비지 컬렉션으로 제거됨 
