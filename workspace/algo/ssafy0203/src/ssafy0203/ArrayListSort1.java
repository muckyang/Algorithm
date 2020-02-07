package ssafy0203;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListSort1 {
	public static class IC2 implements Comparator <Integer>{

		//양수이면 오름차순  음수이면 내림차순
		@Override
		public int compare(Integer o1, Integer o2) {
			return -(o1-o2);
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(-1);
		list.add(3);
		list.add(4);
		list.add(-71);
		list.add(17);
		list.add(-14);
		list.add(1125);
		for(int as : list) {
			System.out.print( as + " ");
		}
		System.out.println();
		
		for(int i= 0 ; i <list.size(); i++) {
			System.out.print( list.get(i) + " ");
		}
		System.out.println();
		list.sort(new IC2());

		for(int as : list) {
			System.out.print( as + " ");
		}
		System.out.println();
	}
}
