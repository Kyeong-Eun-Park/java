package interface_;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 인터페이스의 default 메서드
		 * 충돌 발생 시 예외처리
		 * 
		 * 1. class vs interface (class Win)
		 * 2. interface vs interface (반드시 override)
		 * 
		 * */
		// 1. class vs interface (class Win)
		C c = new C();
		c.test();
		
		// 2. interface vs interface (반드시 override)
		SubClass sub = new SubClass();
		sub.method();
	}
}

class A {
	public void method() {
		System.out.println("class A");
	}
}

interface B {
	default void method() {
		System.out.println("interface B");
	}
}

class C extends A implements B {
	public void test() {
		method();
	}
}

// 2. interface vs interface (반드시 override)
interface I1 {
	default void method() {
		System.out.println("I1의 메서드");
	}
}

interface I2 {
	default void method() {
		System.out.println("I2의 메서드");
	}
}

class SubClass implements I1, I2 {

	@Override
	public void method() {
		System.out.println("SubClass의 메서드");
		
		// 인터페이스에서의 super
//		I1.super.method();
		I1.super.method();
		I2.super.method();
	}
}


abstract class SuperClass {
	String name;
	int age;
	public SuperClass(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}

class SubClass2 extends SuperClass {

	public SubClass2(String name, int age) {
		super(name, age);
	}
	
}














