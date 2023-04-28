package try_catch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 하나의 try 블록에서 복수개의 예외를 처리하는 경우
		 * - try 블록 내에서 처리해야하는 예외가 두 종류 이상일 경우
		 * 	 catch 블록을 해당 예외 종류만큼 작성하거나
		 *   하나의 catch 블록에서 복수개의 예외를 모두 처리하는 클래스를 사용하면 된다.
		 * - 복수개의 catch블록은 첫번째 catch블록 부터 차례대로 탐색함
		 *   => 만약, 끝까지 탐색했음에도 일치하는 catch블록이 없으면 실행 시 예외 발생함
		 * - *만약, 복수개의 catch 블록 지정 시 하위 타입부터 상위 타입순으로 나열해야함
		 *   (ex. ArithmeticException 보다 Exception 클래스가 위에 있을 수 없다!)    
		 * - 만약, 하나의 catch블록으로 복수개의 예외를 처리하려면
		 *   1) catch 블록의 클래스를 복수개의 예외 클래스의 상위 타입으로 지정하면 된다!
		 *   	(ex. 모든 예외를 처리하기 위해서는 Exception 클래스를 지정)
		 *   2) catch 블록의 클래스에 | 기호를 사용하여 복수개의 클래스를 기술해도 된다!
		 *   	(ex. FileNotFoundException | ClassNotFoundException)
		 * */
		System.out.println("프로그램 시작!");
		
		try {
			
			// 첫번째 예외: ArithmeticException
			int num1 = 3, num2 = 1;
			System.out.println(num1 / num2);
			
			// 두번째 예외: NullPointerException
//			String str = null;
			String str = "홍길동";
			System.out.println(str.length());
			
			// 세번째 예외: ArrayIndexOutOfBoundsException
			int[] arr = {1};
			System.out.println(arr[0]);
			
		} catch (ArithmeticException e) {
			System.out.println("예외 발생: 0으로 나눌 수 없습니다!");
		} catch (NullPointerException e) {
			System.out.println("예외 발생: null 값을 참조할 수 없습니다!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생: 잘못된 인덱스를 참조합니다!");
		} catch (Exception e) { // 마지막으로 확인하는 catch 블록
			// 위의 세가지 예외에 해당되지 않는 예외를 모두 Exception 타입으로 catch 함
			// => if문에서 else문 역할과 동일함
			System.out.println("예외 발생: 나머지 예외를 모두 처리합니다!");
		}
		
		System.out.println("프로그램 종료!");
		
		
		try {
			// FileNotFoundException 
			FileInputStream fis = new FileInputStream("");
			// ClassNotFoundException
			Class.forName("");
		} catch (ClassNotFoundException | FileNotFoundException e) {
			System.out.println("ClassNotFoundException 또는 FileNotFoundException 발생!");
		}
		
		
		
		
		
		
		
	}

}
