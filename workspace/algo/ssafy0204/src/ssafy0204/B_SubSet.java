package ssafy0204;

public class B_SubSet {
	public static void main(String[] args) {

		int[] m = { 1, 4, -2, 3, 5, 7, 8, 6, 9 };
		//부분집합
		for(int i = 0  ; i < (1<< m.length) ; i++) {
			int sum = 0;
			for(int j = 0 ; j < m.length; j++) {
				if(( i & (1 << j)) == 0) {
					sum += m[j];
					System.out.print(m[j] + " ");
				}
			}
			System.out.println();
			System.out.println(sum + " ");
		}
		

		//		System.out.println((int)Math.pow(2,m.length));
	}
}
