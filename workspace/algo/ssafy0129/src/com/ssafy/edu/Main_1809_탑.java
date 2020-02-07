package com.ssafy.edu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1809_탑 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader sb = new BufferedReader(
	                new InputStreamReader(System.in));
	         
	        int N = Integer.parseInt(new StringTokenizer(sb.readLine()).nextToken());
	        int[] list = new int[N];
	        int[] take = new int[N];
	       
	        String S;
	        S = sb.readLine();
	        StringTokenizer st = new StringTokenizer(S);
	         
	        for (int i = 0; i < N; i++) {
	            list[i] = Integer.parseInt(st.nextToken());
	        }
	        for (int i = N - 1; i >= 0; i--) {
	            for (int j = i - 1; j >= 0; j--) {
	                if(list[i] < list[j]) {
	                    take[i] = j+1;
	                    break;
	                }
	                      
	            }
	        }
	          
	        for (int i = 0; i < N; i++) {
	            System.out.print( take[i] + " ");
	        }
	  
	    }
	}