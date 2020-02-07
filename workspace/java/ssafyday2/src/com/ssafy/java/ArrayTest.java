package com.ssafy.java;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

	static int[] list = { 34, 23, 64, 25, 12, 75, 22, 88, 53, 37 };

	private static void print() {

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();

	}

	private static void total() {
		// TODO Auto-generated method stub
		int sum = 0;

		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		System.out.println("배열의 합     :" + sum);
	}

	private static void average() {
		double avg = 0.0;
		int sum = 0;

		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		avg = sum / 10.0;
		System.out.println("배열의 평균   : " + (int) avg);
	}

	private static void minimum() {
		int min = 10000000;
		for (int i = 0; i < list.length; i++) {
			if (min > list[i]) {
				min = list[i];
			}
		}
		System.out.println("배열의 최소값:" + min);

	}

	private static void selectionSort() {

		Arrays.sort(list);
		System.out.print("선택정렬 후 : ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print();
		total();
		average();
		minimum();
		selectionSort();
	}
}
