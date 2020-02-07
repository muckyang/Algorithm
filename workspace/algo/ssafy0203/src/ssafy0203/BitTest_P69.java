package ssafy0203;

public class BitTest_P69 {
	public static void main(String[] args) {
		int arr[] = { -1, 2, -3, 4, -5, 6, -7, 8, -9, 10 };
		int count = 0;
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < (1 << n); i++) {
			sum = 0;
			int check = 1;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) == 0) {
					System.out.print(arr[j] + " ");
					check = 0;
					sum += arr[j];
				}
			}
			System.out.println();
			if (sum == 0 && check == 1) {
				count++;
				System.out.println(count);
			}
		}

	}
}
