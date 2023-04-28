package langPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * Arrays 클래스
		 * - 배열 관련 다양한 기능을 제공하는 클래스
		 * - static 메서드가 제공되므로 클래스명만으로 호출 가능
		 * */
		ArrayList list = new ArrayList<>(Arrays.asList(40, 45, 10, 33, 1, 42));
		System.out.println(list); // toString() 생략
		System.out.println(list.toString()); 
		
		int[] myLotto = {40, 45, 10, 33, 1, 42};
		System.out.println(myLotto);
		
		for(int i = 0; i < myLotto.length; i++) {
			System.out.print(myLotto[i] + " ");
		}
		System.out.println();
		
		// Arrays 클래스를 활용하여 배열의 모든 요소 출력
		// => Arrays.toString() 메서드를 사용하면 배열 내의 모든 요소를 문자열로 리턴해줌
		System.out.println(Arrays.toString(myLotto));
		
		System.out.println("----------------------------------------");
		
		// 배열 요소를 정렬(sort) - Arrays.sort() 메서드 사용
		// 정수는 오름차순(0 -> 9)으로 정렬
		Arrays.sort(myLotto);
		System.out.println("정렬 후 " + Arrays.toString(myLotto));
		
		System.out.println("----------------------------------------");
		// 문자열은 알파벳 오름차순 (A -> Z)으로 정렬
		String[] subject = {"Java", "Android", "Oracle", "JSP", "HTML5"};
		Arrays.sort(subject);
		System.out.println("정렬 후 " + Arrays.toString(subject));
		
		
		
		
		
		
	}

}
