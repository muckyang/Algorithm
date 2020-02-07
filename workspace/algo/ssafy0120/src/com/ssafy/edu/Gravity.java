package com.ssafy.edu;

import java.util.Scanner;

public class Gravity {
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); // ������ ��ϻ����� 
		max = 0;
		
		int[][] array = new int[size][size];		//ȸ���� ���� ��ġ�� �迭
		int[][] result = new int[size][size];		//�� ���ڰ� ��ĭ�� ������ �� �ִ��� �����ϴ� �迭
		int[] length = new int[size];				//ȸ���� �迭�� �� �� ���� (ȸ������ ����)
		
		
		for(int i = 0; i < size; i++) {
			int n = sc.nextInt(); 
			length[i] = n; // ���̰� �� ���̷� ����
			//���� ���� ��ȯ��Ŵ
			for(int j = 0 ; j < n; j++) {
				array[i][j] = 1;				//���ڰ� �ִ� �κ��� 1�� ����
			}
		}
		// ���� �Ʒ��� �ִ� ���ڿ� ���� ���� ��Ų��. 
		for(int i = size-1; i >= 0; i--) {
			for(int j = 0 ; j < length[i]; j++) {
				go(array,length,i,j,result);		//�� ���ڿ� ���ؼ� �������
			}
		}
		System.out.println(max);
	}
	
	public static void go(int[][] array, int[] length, int y_index, int index,int[][] result) {
		int size = array.length;
		for(int j = y_index + 1; j < size; j++) {		//���� ��ĭ���� Ž��
			if(array[j][index] != 0) {				//���ڰ� �ִٸ�
				result[y_index][index] = j-y_index-1 + result[j][index];	//�ڽ��� ��ġ�� �Ʒ� ������ ��ġ�� �� + �Ʒ����ڰ� �󸶳� ������ �� �ִ���
				break;
			}
			else if(j == size-1) {					//�ƹ� ���ڵ� �������ٸ�
				result[y_index][index] = j-y_index;	//�� �Ʒ����� �������� ������ size-1 - y_index
			}
		}
		//�� ������ ������ �ִ� ���̸� ����
		max = max > result[y_index][index] ? max : result[y_index][index];	}
}
