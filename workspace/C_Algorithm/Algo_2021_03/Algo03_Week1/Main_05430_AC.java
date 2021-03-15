package Algo03_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_05430_AC {
	static int T;
	static StringBuilder sb;
	static int arr[];

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();

			boolean fe = true;// 진행방향 t -> , f <-
			int front = 0;
			int end = Integer.parseInt(br.readLine()) - 1;
			String numS = br.readLine();
			numS = numS.substring(1, numS.length() - 1);
			arr = new int[end + 1];
			StringTokenizer st = new StringTokenizer(numS, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				arr[cnt++] = Integer.parseInt(st.nextToken());
			}
			for (int d = 0; d < s.length(); d++) {
				char c = s.charAt(d);
				if (c == 'R') {
					fe = !fe;
				}
				if (c == 'D') {
					if (fe) {// 정방향
						front++;
					} else {
						end--;
					}
				}
				if (front - end > 1)
					break;

			}
			if (front - end > 1) {// error 발생
				sb.append("error\n");
				continue;
			} else if (front - end == 1) {
				sb.append("[]\n");
				continue;
			}
			// 입력 완료
			printArr(front, end, fe);
		}
		System.out.println(sb.toString());

	}

	private static void printArr(int front, int end, boolean fe) {
		sb.append("[");
		if (fe) { // 정방향이다
			while (true) {
				sb.append(arr[front++]);
				if (front > end) {
					break;
				}
				sb.append(",");
			}
		} else {
			while (true) {
				sb.append(arr[end--]);
				if (front > end) {
					break;
				}
				sb.append(",");
			}
		}
		sb.append("]").append("\n");

	}
}
