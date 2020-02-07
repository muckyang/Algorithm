package ssafy0203;

public class FibonachiTest1_메모이제이션 {
	static long []list;
	public static void main(String[] args) {
		list= new long[100000];
		list[0]= list[1]= 1;
		double s=1.0;
		for(int i = 0 ; i < 30 ; i ++) {
			s *= 1.55;
		}
		System.out.println(s);
		for(int i = 2 ; i < 100000;i++) {
			list[i] = list[i-1] + list[i-2];
		}
		System.out.println(list[19]);
		System.out.println(list[60]);
		System.out.println(list[77]);
		System.out.println(list[78]);
		System.out.println(list[80]);
		System.out.println(list[81]);
		System.out.println(list[82]);
		System.out.println(list[89]);
		System.out.println(list[90]);
		System.out.println(list[91]);
	}	 
}
