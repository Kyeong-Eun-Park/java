package lambda;

import java.util.function.Consumer;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 자바에서 제공되는 함수형 인터페이스
		 * java.util.function 패키지
		 * 
		 * 				파라미터	리턴
		 * Consumer 계열	O		X
		 * Supplier 계열	X		O
		 * Function 계열	O		O
		 * Operation계열	O		O
		 * Predicate계열	O		boolean
		 * 
		 * 1. Consumer 계열 (소비자)
		 * - 파라미터를 받아서 소비한다.
		 * - 리턴 하지 않는다.
		 * */
		
		// 익명의 내부클래스 방식
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		consumer.accept("Hello");
		
//		var a = t => console.log(t);
		Consumer<String> consumer2 = t -> System.out.println(t);
		consumer2.accept("Hello2");
		
		System.out.println("----------------------------");
		
		Student s1 = new Student("홍길동", 80);
		printStudent(s1, s -> System.out.println(s.name));
		printStudent(s1, s -> s.score *= 1.5);
		printStudent(s1, s -> System.out.println(s.name + " : " + s.score));
		
		
	}
	
	// 학생을 출력할 것이다. (아직 방식은 미정)
	// 출력방식을 전달 받는다. (Consumer<Student> printer)
	public static void printStudent (Student s, Consumer<Student> printer) {
		printer.accept(s);
	}

}

class Student {
	String name;
	double score;
	
	public Student(String name, double score) {
		this.name = name;
		this.score = score;
	}
}






