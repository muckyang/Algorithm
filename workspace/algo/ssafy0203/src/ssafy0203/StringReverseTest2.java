package ssafy0203;

public class StringReverseTest2 {
	public static void main(String[] args) {
		char[] cs ;
		String h = "hello my name is ssafy!";
		cs = h.toCharArray();
		for(int i =  0; i < cs.length / 2 ;i++) {
			char c= cs[i];
			cs[i] = cs [cs.length - 1 - i];
			cs[cs.length - 1 - i] = c;
			System.out.println(String.valueOf(cs));
		
		}
		
		System.out.println(String.valueOf(cs));
	}
}
