package ssafyday2;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.*;

/** com : 서로 다른 3자리난수 */
/*
 * 1. 0으로 시작하면 안댐 2. 숫자비교 각 자리수마다 숫자가 같다면 -> 자리수가 같다면 strike ++ or -> 아니라면
 * ball++ 3. 스트라이크 == 3 -> 정답! != 3 -> x st , x ball
 */
public class NumberBaseballGame {
	static int[] com = new int[3];
	static int[] my = new int[3];
	//static Scanner sc = new Scanner(System.in);
	

	public static void nansu() {
		com[0] = (int) (Math.random() * 9) + 1;// 1~9
		do {
			com[1] = (int) (Math.random() * 10);
		} while (com[0] == com[1]);
		do {
			com[2] = (int) (Math.random() * 10);
		} while (com[0] == com[2] || com[1] == com[2]);
		System.out.println("com : " + com[0] + com[1] + com[2]);
	}
	
	
	public static void game() throws IOException {
		
		InputStream is = System.in;
		Reader r= new InputStreamReader(is); // Reader 은 추상클래스로 new하지못함
		BufferedReader in = new BufferedReader(r);
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.print("3자리 수 입력 : ");
			String s = in.readLine();
			int myNum_s = Integer.parseInt(s);
			int myNum = myNum_s;
			for (int i = 0; i < my.length; i++) {
				my[i] = myNum / (int) Math.pow(10, (my.length - i - 1));
				myNum = myNum % (int) Math.pow(10, (my.length - i - 1));
			}

			int strike = 0;
			int ball = 0;

			for (int i = 0; i < my.length; i++) {
				for (int j = 0; j < my.length; j++) {
					if (my[i] == com[j]) {
						if (i == j) {
							strike++;
							break;
						} else {
							ball++;
							break;
						}
					}
				}
			}

			if (strike == 3) {
				System.out.println(myNum_s + "은 정답입니다.");
				break;
			} else {
				System.out.println(myNum_s + "은 " + strike + "스트라이크 " + ball + "볼 입니다.");
			}
		}
		//무한루프 끝
	}
	public static void main(String[] args) throws IOException {
		
		nansu();
		game();
		
	}
}
