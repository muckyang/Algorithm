package com.ssafy.edu;

import java.util.ArrayList;
import java.util.Comparator;

public class C_ArrayListTest3 {

	//인터페이스 
	public static class PC implements Comparator<P>{
		
		@Override
		public int compare(P o1, P o2) {
			double p1 = Math.sqrt(o1.x*o1.x + o1.y*o1.y);
			double p2 = Math.sqrt(o2.x*o2.x + o2.y*o2.y);
			
			if(p1 > p2) // 전에 나온게 크다면 -1 리턴 (그대로 유지)
				return -1;
			else if(p1 < p2) // 후에 나온게 크다면 1 리턴 (순서변경 일어남)
				return 1;
			else //동일
				return 0 ;
		}
		
	}
	
	public static class P{
		int x ;
		int y ;
		public P() {
			
		}
		
		public P(int x , int  y){
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", sqrt_root= "+ Math.sqrt(x*x+y*y) + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
			ArrayList<P> ps = new ArrayList<>();
			
			ps.add(new P(1,4));
			ps.add(new P(2,5));
			ps.add(new P(4,6));
			ps.add(new P(9,2));
			ps.add(new P(5,8));
			
			for (P p : ps) {
				System.out.println(p);
			}
			ps.sort(new PC());
			System.out.println("==========sorted==============");
			for (P p : ps) {
				System.out.println(p);
			}
			
			
	}

}
