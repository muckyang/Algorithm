package com.ssafy.edu;

public class Array1 {
	public static void main(String[] args) {
		int [] a = {1,2,3};
		int [] b = new int [] {1,2,3};
		// a= {1,2}; // �����迭�� ���Ҵ��ϸ� ����
		b = new int[] {1,2,3,4,5,6}; // new int[] {�迭����} ���� ���Ҵ� ����
		System.out.println(a.length);
		System.out.println(b.length);
		
		int [] c = a; // ���� ���� 
		c[1] = -4; //a��
		System.out.println("c[1] : " + c[1]);
		System.out.println("a[1] : " + a[1]);
		
		int [] d = new int[a.length];
		System.arraycopy(a,0,d,0,a.length); //a�� 0 ���� d�� 0�� a.length���̸�ŭ ��������
		d[0] = -5;
		System.out.println("d[0] : " + d[0]);
		System.out.println("a[0] :  " + a[0]);

		
	
	}
}
