package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {

	static int N, M;
	static int nlist[];
	static int mlist[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nlist = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nlist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		mlist = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nlist[i] = Integer.parseInt(st.nextToken());
		}
	}
}
