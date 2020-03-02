package Study_0302;

import java.util.Scanner;

public class Main_1700_멀티탭스케줄링 {
	static int N, K;
	static int[] plug;
	static int[] numOfObject;
	static int[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		plug = new int[N];
		list = new int[K];
		int res= 0;
		numOfObject = new int[101];
		for (int i = 0; i < K; i++) {
			list[i] = sc.nextInt();
			numOfObject[list[i]]++;
		}
		k: for(int i = 0 ; i < K ; i++) {
			numOfObject[list[i]]--;
			for(int j = 0 ; j < N ; j++) {
				if(plug[j] == list[i]) {
					continue k;
				}
			}
			for(int j = 0 ; j < N ; j++) {
				if(plug[j] == 0) {
					plug[j] = list[i];
					continue k;
				}
			}
			for(int j = 0 ; j < N ; j++) {
				if(numOfObject[plug[j]] == 0) {
					plug[j] = list[i];
					res++;
					continue k;
				}
			}
			plug[0] = list[i];
			res++;
		}
		System.out.println(res);
		
	}
}
