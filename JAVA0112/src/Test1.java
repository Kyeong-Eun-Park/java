import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 마방진(magic square) 만들기
		 * 
		 * n * n 마방진 구현방법:
		 * 1. 시작은 첫 행, 한가운데 열에 1을 둔다.
		 * 2. 행을 감소, 열을 증가하면서 순차적으로 수를 넣어간다.
		 * 3. 행은 감소하므로 첫행보다 작아지는 경우에는 마지막 행으로 넘어간다.
		 * 4. 열은 증가하므로 마지막 열보다 커지는 경우에는 첫 열로 넘어간다.
		 * 5. 넣은 수가 n의 배수이면 행만 증가한다.
		 * */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = makeMagicSquare(n);
		printArray(arr);
		
	} // main() 메서드 끝
	
	// 크기 n을 전달받아 n*n 마방진(2차원배열)을 리턴하는 makeMagicSquare()
	public static int[][] makeMagicSquare(int n){
		int[][] arr = new int[n][n];
		// 마방진 만들기
		int row = 0; // 행 인덱스
		int col = n / 2; // 열 인덱스
		for(int i = 1; i <= n*n; i++) { // i = 넣는 수
			arr[row][col] = i;
			
			if(i % n == 0) {
				row++;
			} else {
				row--;
				col++;
			}
			
			if(row < 0)		row = n - 1;
			if(col > n - 1)	col = 0;
		}
		
		return arr;
	}
	
	
	public static void printArray(int[][] arr) {
		// 배열 출력
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
