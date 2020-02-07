package ssafy0204;

import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

public class A_Combination7 {
	static int[] com = { 1, 2, 3, 4, 5, 6 };
	static boolean[] isc;

	public static void nCr(int n, int r, int start, int count) {
		if (count == r) {

			System.out.print(" Yes : ");
			for (int i = 0; i < isc.length; i++) {
				
				if (isc[i]) {
					System.out.print(com[i] + " ");
				}
			}
			System.out.println();
			System.out.print(" No : ");
			for (int i = 0; i < isc.length; i++) {
				if (!isc[i]) {
					System.out.print(com[i] + " ");
				}
			}
			System.out.println();

			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			if (!isc[i]) {
//				com[i]= count+1;
				isc[i] = true;
				nCr(n, r, i + 1, count + 1);
				isc[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		int n = 6;
		int r = 3;
//		com = new int[n];
		isc = new boolean[n]; // false

		nCr(n, n / 2, 0, 0);

		System.out.println();
	}

}
