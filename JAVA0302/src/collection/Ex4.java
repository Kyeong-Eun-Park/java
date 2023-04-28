package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * Stack vs Queue
		 * 1. Stack (스택)
		 * - 하나의 상자에 데이터를 아래쪽(Bottom)에서 부터 차례대로 쌓는 구조
		 * - 데이터의 삽입/삭제가 항상 한쪽(Top)에서만 이루어짐
		 * - 가장 마지막에 추가된 데이터가 가장 먼저 삭제됨 (= LIFO, Last In First Out)
		 *   = 가장 먼저 추가된 데이터가 가장 나중에 삭제됨 (= FILO, First In Last Out)
		 * - 주로 웹브라우저의 뒤쪽/앞으로, 응용프로그램의 Redo/Undo 기능에 활용
		 * */
		Stack stack = new Stack();
		stack.push("1 - www.itwillbs.co.kr");
		stack.push("2 = www.naver.com");
		stack.push("3 - www.youtube.com");
		
		System.out.println("모든 요소 출력 : " + stack);
		System.out.println("www.nate.com 추가 : " + stack.push("4 - www.nate.com"));
		
		// Object peek() : 스택의 맨위의 요소를 리턴 (요소 제거 X)
		System.out.println("맨 위(Top)의 요소 출력(peek) : " + stack.peek());
		System.out.println("맨 위(Top)의 요소 출력(peek) : " + stack.peek());
		
		// Object pop() : 스택의 맨위의 요소를 리턴 (요소 제거 O)
		System.out.println("맨 위(Top)의 요소 출력(pop) : " + stack.pop());
		System.out.println("맨 위(Top)의 요소 출력(pop) : " + stack.pop());
		
		System.out.println("=======================================");
		
		/*
		 * 2. Queue (큐)
		 * - 한쪽에서 추가, 반대편에서 삭제가 일어나는 구조
		 * - 가장 먼저 추가된 데이터가 가장 먼저 삭제되는 구조 (= FIFO, First In First Out)
		 *   = 가장 나중에 추가된 데이터가 가장 마지막에 삭제되는 구조 (= LILO, Last In Last Out)
		 * - Queue 는 인터페이스로 제공되며, 실제 구현 클래스로 LinkedList 클래스 사용  
		 *   => LinkedList 클래스는 List 와 Queue 인터페이스 모두 구현한 클래스
		 * - 주로, 응용프로그램의 최근 문서 항목이나 번호표 시스템(선착순 대기열)에 활용
		 *   => 1개의 큐에 순차적으로 추가한 뒤 차례대로 제거하면서 사용  
		 * */
		Queue q = new LinkedList();
		
		// boolean offer(Object o) : 요소 o를 추가(추가 결과를 boolean 타입으로 리턴)
		q.offer("1 - Ex.java");
		q.offer("2 - main.jsp");
		q.offer("3 - a.txt");
		System.out.println("모든 Queue 객체 출력 : " + q);
		
		System.out.println("Ex2.java 추가 결과: " + q.offer("4 - Ex2.java"));
		System.out.println("모든 Queue 객체 출력 : " + q);
		
		// Object peek() : 큐의 맨 끝의 요소(먼저 추가된 요소)를 리턴(요소 제거 X)
		System.out.println("맨 처음 추가된 요소(peek) : " + q.peek());
		System.out.println("맨 처음 추가된 요소(peek) : " + q.peek());
		
		// Object poll() : 큐의 맨 끝의 요소(먼저 추가된 요소)를 리턴(요소 제거 O)
		System.out.println("맨 처음 추가된 요소(poll) : " + q.poll());
		System.out.println("맨 처음 추가된 요소(poll) : " + q.poll());
		
	}
	

}
