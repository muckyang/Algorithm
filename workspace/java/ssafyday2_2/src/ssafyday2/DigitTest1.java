package ssafyday2;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] list = new int [100];
		int [] count = new int [10];
		int num;
		System.out.println("100미만의 숫자를 연속으로 입력하세요 (0 입력시 실행): ");
		while(true) {
			num = sc.nextInt();
			if(num == 0)
				break;
			count[num / 10]++;
			
		}
		
		for(int i= 0 ; i < count.length; i++) {
			if(count[i] > 0)
				System.out.println(i + "  : "+count[i]+"개");
		}
	}
}
