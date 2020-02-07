package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T= sc.nextInt();
        String S;
        int count = 0;
        for(int test_case = 1; test_case <= T; test_case++)
		{
            
			S=sc.next();
           
            if(S.charAt(0) == '1')
                count = 1;
            for(int i=0; i < S.length()-1 ;i++){
				if(S.charAt(i) != S.charAt(i+1))
                    count++;
                //System.out.print(S.charAt(i));
            }
            
            
            System.out.println("#" + test_case + " " +count);
            count =0;
            
            //System.out.println();
    		}
	}
}
