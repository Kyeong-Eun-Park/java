package super_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * < 변수 사용 시 선언 방법에 따른 접근 순서 >
		 * 1. 변수명만 지정했을 경우
		 * 	  현재 선언된 메서드 내에서 먼저 탐색 -> 없을 경우 자신의 멤버변수에서 탐색
		 *    -> 부모의 멤버변수에서 탐색
		 *    
		 * 2. this.변수명을 지정했을 경우
		 * 	  자신의 멤버변수에서 탐색 -> 부모의 멤버변수에서 탐색	
		 * 
		 * 3. super.변수명을 지정했을 경우
		 * 	  부모의 멤버변수에서 탐색
		 * 
		 * => 결론! 탐색 시작지점을 지정해 준다라고 생각해도 무방함
		 * 
		 * */
		new S().scope();
	}
}

class P {
	String name = "P";
}
class C extends P {
	String name = "C";
}
class S extends C {
	String name = "S";
	public void scope() {
		String name = "로컬";
		System.out.println("name: " + name);
		System.out.println("this.name: " + this.name);
		System.out.println("super.name: " + super.name);
	}
}





