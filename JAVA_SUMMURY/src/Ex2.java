
public class Ex2 {

	public static void main(String[] args) {
		// ---------- 클래스 이후 ------------
		/*
		 * < 클래스에 선언 가능한것 >
		 * - 멤버변수 (속성, 필드)
		 * - 생성자 (객체를 생성하는 방법)
		 * - 메서드 
		 * 
		 * */
		
		/*
		 * < static >
		 * 1. 객체마다 가지는 것이 아닌 클래스에 소속된 것
		 * 2. 객체끼리 공유
		 * 3. 메모리 로딩 타이밍이 더 빠름
		 * */
		
		/*
		 * 레퍼런스 형변환 
		 * 1. 부모타입으로는(업캐스팅) 얼마든지 가능
		 * 2. 자식은 어떤 객체가 저장되어있는지가 중요!
		 * */
		
		/*
		 * 동적 바인딩
		 * - 코드상에서 호출될 것으로 예상되는 메서드와
		 *   실제 실행시점(동적)에 연결되는(바인딩) 메서드가 다른 현상
		 * - 어떤 객체가 저장되어있는지가 중요!  
		 * */
		A a = new B();
		a.method(); // A가 출력될것으로 예상됨
		// => 실제 실행시점에 연결되는 메서드는 B
		
		/*
		 * 다형성 (Polymorphism) (예제중, PolyHero)
		 * - 레퍼런스 형변환(업캐스팅) + 동적바인딩
		 * */
		
		/*
		 * 추상클래스 (abstract class) 
		 * => [추상화를 통해] 공통점을 추출한 클래스
		 * 
		 * 1. 객체를 생성할 수 없음
		 * 	=> 추상적인 개념이므로 생성 X (Drop 되면 안되는 아이템)
		 *  => 클래스이기 때문에 생성자가 있음
		 *  
		 * 2. 추상메서드를 가질 수 있는 클래스
		 * 	=> 추상메서드: abstract 키워드가 붙고 바디 {} 없이 선언만 되어있는 메서드
		 * */
		
		/*
		 * 인터페이스 (interface)
		 * => 순도 100% 상수와 추상메서드만 존재, Java 8에 default 메서드가 추가되긴함
		 * 1. 상수와 추상메서드만 올 수 있으므로
		 * 	  변수는 public static final 생략 가능
		 *    메서드는 public abstract 생략 가능
		 * 2. 다중상속 가능 (인터페이스끼리 extends, 실체 클래스에서는 implements)
		 * 	  => 추상메서드 이므로 이름이 같은 메서드를 2개 물려반더라도
		 *       모호하지 않으므로 다중상속 (O)
		 * 3. 바디가 있는 메서드로는 defualt와 static 메서드 가능
		 * */
		
		/*
		 * Enum (시스템 전역에서 쓰이는 공통 코드값 [selectBox, radio, checkBox]
		 * */
		
		/*
		 * Wrapper 클래스
		 * - 기본데이터타입 8가지와 1:1로 대응되는 클래스들의 모음
		 * - 기본데이터타입은 기능(메서드)이 없으므로 기능을 지원해주는 클래스들의 모음
		 * */
		
		/*
		 * Collection Framwork (API, 라이브러리)
		 * => Set, List, Map
		 * 	1) Set: 중복허용(X) 
		 * 		=> 정렬(TreeSet), 순서(LinkedHashSet), 일반(HashSet)
		 * 	2) List: 배열처럼 인덱스를 가지며 크기 변경 가능
		 * 		=> ArrayList, Vector, LinkedList (데이터중간 추가/삭제가 빠름)
		 * 	3) Map : DTO, JSON 처럼 (key : value) 구조로 이루어진 데이터타입
		 * 		=> 정렬(TreeMap), 순서(LinkedHashMap), 일반(HashMap)
		 * */
		
		/*
		 * String 클래스에서 자주 쓰는 메서드 (코드만 보고 결과를 알아야할 정도)
		 * => split, trim, replace, substring, indexOf, contains 
		 * */
		
		/*
		 * 람다식 (추상메서드가 1개 뿐인 인터페이스의 임시 객체를 생성하는 문법)
		 * 	(파라미터) -> { 실행문... }
		 * 1) 파라미터가 하나이면 () 생략가능
		 * 2) 실행문이 하나이면 {} 생략가능
		 * 3) 연산결과가 return 되어야 하면 return문 생략 가능
		 * */
		I i = new I() {
			@Override
			public void method() {
				
			}
		};
		
		i = () -> {};
	}
}

interface I {
	public void method();
}

enum 장르 {
	코미디("01"), 액션("02");
	
	String code;

	private 장르(String code) {
		this.code = code;
	}
}


class A {
	public void method() {
		System.out.println("A");
	}
}
class B extends A {

	@Override
	public void method() {
		System.out.println("B");
	}
	
}





























