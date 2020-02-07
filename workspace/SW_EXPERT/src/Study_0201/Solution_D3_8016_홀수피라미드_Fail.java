package Study_0201;

import java.util.Scanner;

public class Solution_D3_8016_홀수피라미드_Fail {
	static int T, N;
    static long r_s, r_e;
    
    public static void func() {
    	 if (N % 2 == 0) {
             for (int i = 2; i <= N; i = i + 2) {
                 if (i == 2) {
                     r_s += 2;
                     r_e += 6;
                 } else {
                     r_s += (8L * (i - 2));
                 }
             }
         } else {
             for (int i = 3; i <= N; i = i + 2) {
                 if (i == 3) {
                     r_s += 8;
                     r_e += 16;
                 } else {
                     r_s += (8L * (i - 2));
                 }
             }
         }
         if (N > 3)
             r_e = (r_s + (8L * (N - 2)))-(N-3)*4;
          
    }
    
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            r_s = 1L;
            r_e = 1L;
            N = sc.nextInt();
            func();             
            System.out.println("#" + test_case + " " + r_s + " " + r_e);
             
        }
 
    }
}