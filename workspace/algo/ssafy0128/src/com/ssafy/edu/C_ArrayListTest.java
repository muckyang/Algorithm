package com.ssafy.edu;

import java.util.ArrayList;

public class C_ArrayListTest {

	public static void main(String[] args) {	
		ArrayList<Integer> ns =new ArrayList<>(); // new로 생성시 <Integer> 생략해도 됨
		ns.add(3);// 가장 뒤에 삽입 integer로 박싱
		ns.add(7);
		ns.add(4);
		ns.add(1,4);// 1번째 위치에 삽입
		ns.add(7);
		ns.set(3,7);// 3번째 자리에 바꿔치기
		//ns.clear();//전체 삭제
		//ns.indexOf(3);
		Object o = 3;// (자바)객체의 최상위인 Object로 받음
		
		int i = (int)o;
		int ii = (Integer)o;
		System.out.print("a : ");
		
		for(int a : ns){
			System.out.print(a + " ");
		}
		
		System.out.println();
		System.out.print("b : ");
		
		for(int j = 0; j < ns.size(); j++) {
			int b = ns.get(j);
			System.out.print(b + " ");
		}
		
		System.out.println();
		System.out.println(ns.contains(7)); // arraylist.contains(in) ; 내부에 존재하느냐?
		Object[] oo = ns.toArray(); // 
	}
}
