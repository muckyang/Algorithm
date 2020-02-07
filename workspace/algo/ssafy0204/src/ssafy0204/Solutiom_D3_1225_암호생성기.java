package ssafy0204;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class Solutiom_D3_1225_암호생성기 {
	static int T; // dummy
	static Queue<Integer> que;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case =1 ; test_case < 11; test_case ++) {
			T = sc.nextInt(); //dummy
			que = new LinkedList<>();
			int count = 1;
			for(int i = 0  ; i <  8 ; i++) {
				que.offer(sc.nextInt());
				
			}
			while(true) {
				//System.out.println("test : " + que);
				if(que.peek() - count <= 0) {
					int q = que.poll();
					q= 0 ;
					que.offer(q);
					break;
				}
				int k = que.poll();
				k = k -  count;
				que.offer(k);
				count ++ ;
				if(count == 6)
					count=1;
			}
			
			System.out.print("#"+ test_case + " ");
            for(int i= 0 ; i < 8; i++){
				System.out.print(Integer.toString(que.poll())+ " ");
            }
			System.out.println();
			que.clear();
		}
	}
}
