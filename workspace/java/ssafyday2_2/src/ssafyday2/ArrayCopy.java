package ssafyday2;

public class ArrayCopy {
	public static void main(String[] args) {
		int [] fromArray = {1,2,3,4,5,6,7,8,9,10};
		int [] copyArray = new int [100];
		
		for(int i = 0 ; i < 10 ; i++) {
			System.arraycopy(fromArray, 0, copyArray, 0 + i*10, 10);
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++)
				System.out.print(copyArray[i*10 + j] + "  ");
			
			System.out.println();
		}
	}
}
