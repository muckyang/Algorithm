package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_StringBuffer_Test {
	static long sum;
	static int N;
	static int [] oneh;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			sum = 0L;// 뒤에 long타입인 것을 명시해줌
			N = Integer.parseInt(br.readLine());// 줄 단위로 읽은 것을 띄어쓰기 단위로 쪼갬

			st = new StringTokenizer(br.readLine());// checked Execption
			oneh = new int[N];

			for (int i = 0; i < N; i++) {
				oneh[i] = Integer.parseInt(st.nextToken().trim());
			}
		}
	}

}
