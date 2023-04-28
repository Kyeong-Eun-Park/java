package _class;

public class Ex2 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		System.out.println("이름: " + s1.name);
		System.out.println("학번: " + s1.id);
		System.out.println("나이: " + s1.age);
		
		// 또 다른 Student 인스턴스 생성
		// => 서로 다른 공간에 생성되는 인스턴스 이지만, 이름과 학번이 지정된 값으로 동일함
		Student s2 = new Student();
		System.out.println("이름: " + s2.name);
		System.out.println("학번: " + s2.id);
		System.out.println("나이: " + s2.age);
		
		System.out.println("------------------------------------");
		s1.name = "이순신";
		s1.id = "a1234567";
		s1.age = 20;
		s1.kor = 100;
		s1.eng = 80;
		s1.mat = 50;
		
//		System.out.println("이름: " + s1.name);
//		System.out.println("학번: " + s1.id);
//		System.out.println("나이: " + s1.age);
		s1.showStudentInfo();
		System.out.println("------------------");
		s2.showStudentInfo();
		System.out.println("=================================");
		System.out.println("s1의 합계: " + s1.getTotal());
		System.out.println("s2의 합계: " + s2.getTotal());
		System.out.println("s1의 평균: " + s1.getAverage());
		
	}
}

// Student 클래스 정의
// - 멤버변수 : 이름(name, 문자열), 학번(id, 문자열), 나이(age, 정수)
//			  국어점수(kor, 정수), 영어점수(eng, 정수), 수학점수(mat, 정수)
class Student {
	// 멤버변수는 초기값을 지정해도되고, 생략도 가능
	// => 만약, 초기값을 지정할 경우 인스턴스 생성할 때마다 해당 초기값으로 초기화
	//   초기값 지정을 생략하는 경우 기본값으로 자동 초기화
	String name = "홍길동";	// 모든 인스턴스에서 name의 기본값을 "홍길동" 으로 갖게됨	
	String id = "a0000000";	// 모든 인스턴스에서 id의 기본값을 "a0000000" 으로 갖게됨
	int age;
	int kor;
	int eng;
	int mat;
//	int computer;
	
	// showStudentInfo() 메서드 정의
	// 파라미터, 리턴값 없음. 다음과 같이 출력
	// 이름: XXX
	// 학번: XXX
	// 나이: XXX ...
	public void showStudentInfo() {
		// 자신의 클래스에서 선언된 멤버변수는 클래스 내의 모든 메서드에서 접근이 가능
		// => 이때, 별도의 주소 지정없이 변수명만으로 접근가능
		// => 각 인스턴스에서 동일한 메서드를 호출하더라도
		//    인스턴스마다 멤버변수가 다르므로 실행 시 실제 저장된 데이터들은 서로 다름
		System.out.println("이름: " + name);
		System.out.println("학번: " + id);
		System.out.println("나이: " + age);
		System.out.println("국어점수: " + kor + "점");
		System.out.println("영어점수: " + eng + "점");
		System.out.println("수학점수: " + mat + "점");
	}
	
	// 국어, 영어, 수학 점수의 합계를 리턴하는 getTotal()
	public int getTotal() {
//		int sum = kor + eng + mat;
//		return sum;
		return kor + eng + mat;
	}
	
	// 국어, 영어, 수학 점수의 평균을 리턴하는 getAverage()
	public double getAverage() {
//		double avg = (kor + eng + mat) / 3.0;
//		return avg;
		
//		return (kor + eng + mat) / 3.0;
		
		// 합계 계산 코드를 직접 작성하지 않고, 기존의 getTotal() 메서드를 재사용
		// => 메서드 내에서 자신의 클래스 내에 있는 다른 메서드를 호출할 경우
		//    멤버변수 접근 방법과 동일하게 호출하면됨!
		return getTotal() / 3.0;
	}
	
}
