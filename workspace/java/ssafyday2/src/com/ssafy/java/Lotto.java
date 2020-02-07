package com.ssafy.java;

import java.util.Random;

public class Lotto {
	Random r = new Random();
	int index = 0;
	int[] lo = new int[6];
	boolean a;
	int len = lo.length;
	
	public void selectLotto() {		
		for (int i = 0; i < len; i++) {
			lo[i] = uniqueNumber(i);
		}
	}

	private int uniqueNumber(int index) {
		int imsi;
		boolean eq = false;
		do {
			imsi = r.nextInt(10) + 1;
			for(int i =0; i < index; i++) {
				if(imsi == lo[i]) {
					eq = true;
					break;
				}
			}
			System.out.println("imsi : " + imsi);
		}while(eq);
		
		return imsi;
	}

	void print() {
		System.out.print(" * 로또당첨번호=>");
		for(int i = 0; i < len ; i++) {
			System.out.print("\t"+lo[i]);
		}
	}

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.selectLotto();
		lotto.print();
	}

}
