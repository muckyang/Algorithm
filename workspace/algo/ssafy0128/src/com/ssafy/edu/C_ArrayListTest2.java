package com.ssafy.edu;

import java.util.ArrayList;

public class C_ArrayListTest2 {

	public static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
		//아무 생성자도 쓰지않으면 디폴트 생성자가 적용되지만 다른생성자를 사용하면
		//디폴트 생성자는 적용되지 않기 때문에 명시해줘야 한다.
		public Point() {
			this.x = 100;
			this.y = 100;
			
		}
		
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point();
		Point p2 = new Point(5,2);
		System.out.println(p1.x);
		System.out.println(p1.y); 
		System.out.println(p2.x);
		System.out.println(p2.y); 
		System.out.println(p1); 
		System.out.println(p2);
			
		Point [] pp = new Point[3];
		pp[0] = new Point(); // 객체형 배열 인덱스 생성
		pp[1] = new Point(3,6); // 객체형 배열 인덱스 생성
		pp[2] = new Point(5,6); // 객체형 배열 인덱스 생성
		
		for (Point pt: pp) {
			System.out.println(pt);
		}
		for (int i = 0; i < pp.length; i++) {
			Point pt = pp[i];
			System.out.println(pt);
		}

		ArrayList<Point> ps = new ArrayList<>();
		ps.add(new Point(4,5));		
		ps.add(new Point(6,7));
		ps.add(new Point(9,20));
		
		for (Point pt: ps) {
			System.out.println(pt);
		}
		
		
		for (int i = 0; i < ps.size(); i++) {
			Point pt = ps.get(i);
			System.out.println(pt);
		}
	}

}
