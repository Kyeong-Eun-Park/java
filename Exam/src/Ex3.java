
/*
 * 클래스 작성 문제
 * 
 * 클래스 이름: Student
 * 멤버변수: 이름(문자열, name), 성적(정수, score)
 * 메서드: 이름(name)과 성적(score)를 출력하는 print() 메서드
 * 		  => 파라미터 없음, 리턴값 없음
 * */

class Student {
	String name;
	int score;
	
	
	
	public void print() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + score);
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class Ex3 {

	public static void main(String[] args) {
		 Student s = new Student("차동원", 100);
		 s.name = "asdjabsdh";
		 s.print();
	}

}
