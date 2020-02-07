package ssafy0203;

public class MagicTest {
	private int[][] magic;
	private int n;

	public MagicTest(int n) {
		this.n = n;
		magic = new int[n][n];

	}
//
//	public MagicTest() {
//		this.n = 3;
//		magic = new int[n][n];
//	}

	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(magic[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void makeMagic() {
		int y = 0;
		int x = n / 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[y][x] = i * n + j + 1;

				int tx = x;
				int ty = y;

				if (x - 1 < 0) {
					x = n - 1;
				} else {
					x--;
				}
				if (y - 1 < 0) {
					y = n - 1;
				} else {
					y--;
				}

				if (magic[y][x] != 0) {
					x = tx;
					y = ty + 1;

				}
			}
		}
	}

	private void check() {
	
	}
	private int sumRow(int r) {
		int sum = 0;
		for(int i = 0; i <n;i++)
			sum+=magic[r][i];
		return sum;
	}
	
	private int sumCol(int c) {
		int sum=0;
		for(int i = 0; i <n;i++)
			sum+=magic[i][c];
		return sum;
	}
	
	private int sumDia() {
		int sum=0;
		for(int i = 0; i <n;i++)
			sum+=magic[i][i];
		return sum;
	}
	private int sumAntiDia() {
		int sum=0;
		for(int i = 0; i <n;i++)
			sum+=magic[i][n-i-1];
		return sum;
	}
	
	
	public boolean isMagic() {		
		boolean isS = true;
		int [] ss = new int[2*n+2];
		
		for(int i = 0 ; i < n;i++) {
			ss[i] = sumRow(i);
			ss[i+n] = sumCol(i);
		}
		
		ss[2*n] = sumDia();
		ss[2*n+1] = sumAntiDia();

		// ss 중에 다른게 하나라도 있으면 false 리턴
		for(int i = 1 ; i < ss.length;i++) {
			if(ss[0] !=ss[i]) {
				isS=false;
				break;
			}
		}
		return isS;
	}
	
	public static void main(String[] args) {
		MagicTest c = new MagicTest(5);
		c.makeMagic();
		System.out.println(c.isMagic());
		c.print();
	}
}
