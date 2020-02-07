package ssafy0203;

public class StringReverseTest1 {
	public static void main(String[] args) {
		String h = "tommot";

		StringBuffer sb = new StringBuffer(h);
		StringBuffer sa = new StringBuffer(h);
		sb.reverse();
		System.out.println(sb  + " " + sa);
		
		System.out.println(sb==sa ? "1" : "2");
		
		System.out.println(sb.equals(sa) ? "1" : "2");
	}
}
