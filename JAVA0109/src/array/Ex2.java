package array;

import java.util.ArrayList;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 배열 사용 시 주의 사항
		 * - 배열 선언 시 [] 기호를 데이터타입 뒤 또는 변수명 뒤에 붙일 수 있으나
		 *   가급적 데이터타입 뒤에 붙여서 표기하도록 해야함
		 *   => 데이터타입[] 변수명; 또는 데이터타입 변수명[]
		 *      int[] a;			 int a[];
		 * */
		int[] a;
		int b[];
		
		// 만약, 동일한 데이터타입 변수를 한꺼번에 선언하는 경우
		int[] c, d;	// 변수 c와 d모두 배열 변수로 선언됨
		int e, f[];	// 변수 e는 기본타입변수, 변수 f만 배열 변수로 선언됨
		
		/*
		 * - 배열 크기는 고정이므로 크기를 확장하려면
		 *   새로운 배열을 생성하고, 기존 데이터를 새 배열에 복사해야함
		 *   (참고. ArrayList를 사용하면 크기확장 가능)
		 * */
		int[] arr = {10, 20, 30};	// 3개의 데이터가 저장된 배열
		// 만약, 점수 40을 추가할 경우 추가(확장) 불가능
		// 따라서, 4개의 정수가 저장되는 배열을 새로 생성한 후 기존 배열 데이터를 복사해야함
		
//		int[] arr2 = new int[4];
		int[] arr2 = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
//		arr2[3] = 40;
		arr2[arr2.length - 1] = 40;
		
		// arr2 데이터 확인
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println("====================================");
		
		// 참고. ArrayList
		ArrayList list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 배열크기 확장 가능
		list.add(40);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("====================================");
		
		int aNum = 10;
		int bNum = 20;
		bNum = aNum; // aNum의 데이터를 bNum에 저장 (기존에 있던 20은 제거됨)
		
		int[] aArr = {1, 2, 3};
		int[] bArr = {4, 5, 6};
		int[] cArr = {7, 8, 9};
		
		aArr = bArr; // bArr 이 가리키는 4, 5, 6 공간의 주소값을 aArr변수에 저장
		// 이때, aArr이 가리키는 1, 2, 3 공간은 더이상 아무도 참조하지 않는 상태가 됨
		// 따라서, 더 이상 참조되지 않는 힙 공간의 영역은 가비지 컬렉터(G.C)에 의한 정리 대상이됨!
		// 즉, 쓸모없는 공간은 메모리 확보를 위해 자동으로 제거됨
		
		bArr = cArr; // cArr 이 가리키는 7, 8, 9 공간의 주소값을 bArr 변수에 저장
		// 이때, bArr이 가리키는 4, 5, 6 공간은 여전히 aArr이 참조하고 있으므로
		// 가바지 컬렉터에 의한 제거 대상이 아니다!
		
		
		
		
	}

}
