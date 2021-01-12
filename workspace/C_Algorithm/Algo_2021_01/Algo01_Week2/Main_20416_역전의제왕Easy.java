package Algo01_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20416_역전의제왕Easy {
	static int N, K;
	static Participant part[];
	static PriorityQueue<Solution> pq[];
	static int res;

	public static class Solution implements Comparable<Solution> {
		int index;
		int proNumber;
		int time;
		int cnt;

		@Override
		public String toString() {
			return "Solution [index=" + index + ", proNumber=" + proNumber + ", time=" + time + ", cnt=" + cnt + "]";
		}

		public Solution(int index, int proNumber, int time, int cnt) {
			this.index = index;
			this.proNumber = proNumber;
			this.time = time;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Solution o) {
			return this.proNumber - o.proNumber;
		}
	}

	public static class Participant implements Comparable<Participant> {
		int index;
		int solution;
		int panalty;
		int lasttime;
		int point;

		public Participant(int index, int solution, int panalty, int lasttime, int point) {
			this.index = index;
			this.solution = solution;
			this.panalty = panalty;
			this.lasttime = lasttime;
			this.point = point;
		}

		@Override
		public String toString() {
			return "Participant [index=" + index + ", solution=" + solution + ", panalty=" + panalty + ", lasttime="
					+ lasttime + ", point=" + point + "]";
		}

		@Override
		public int compareTo(Participant p) {
			if (this.solution == p.solution) {
				if (this.panalty == p.panalty) {
					return this.lasttime - p.lasttime;
				} else
					return this.panalty - p.panalty;
			} else
				return p.solution - this.solution;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		part = new Participant[N];
		pq = new PriorityQueue[N];
		res = 0;
		for (int i = 0; i < N; i++) {
			part[i] = new Participant(i, 0, 0, 0, 0);
			pq[i] = new PriorityQueue<>();
		}
		int freezeCnt = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int time = stringToMin(st.nextToken());
			int partId = Integer.parseInt(st.nextToken()) - 1;
			int probNum = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			if (time > 180) {// 프리징
				freezeCnt++;
				pq[partId].add(new Solution(partId, probNum, time, cnt));
			} else {// 그 전까지
				part[partId].solution++;
				part[partId].panalty += time + (cnt - 1) * 20;
				part[partId].lasttime = time;
			}

		}
		int sp = N - 1;
//		for (Participant p : part) {
//			System.out.println(p.toString());
//		}

		Arrays.sort(part); // 프리징 전 까지의 순위
		while (freezeCnt != 0) {
			while (true) {
				if (sp == 0)
					break;
				if (pq[part[sp].index].isEmpty()) {
					sp--;
					continue;
				}
				Solution p = pq[part[sp].index].poll();
				part[sp].solution++;
				part[sp].panalty += p.time + (p.cnt - 1) * 20;
				part[sp].lasttime = p.time;
				break;
			}
			int before = part[sp].index;
			int upStair = 0;
			Arrays.sort(part); // 문제 적용후 순위
//			for (Participant p : part) {
//				System.out.println(p.toString());
//			}
//			System.out.println();
			for (Participant p : part) {
				upStair++;
				if (before == p.index)
					break;

			}
			part[sp].point += upStair - before + 1;
			freezeCnt--;
		}
		int maxPoint = 0;
		for (Participant p : part) {
			if (maxPoint < p.point) {
				maxPoint = p.point;
				res = p.index + 1;
			}
		}

		System.out.println(res);
	}

	@Override
	public String toString() {
		return "Main_20416_역전의제왕Easy []";
	}

	private static int stringToMin(String str) {
		String sarr[] = new String[2];
		sarr = str.split(":");
		return Integer.parseInt(sarr[0]) * 60 + Integer.parseInt(sarr[1]);
	}
}
