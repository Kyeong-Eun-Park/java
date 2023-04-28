
public class Ex6 {

	int num1;
	int num2;
	
	static int w;
	static int h;
	
	public Ex6(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public static void main(String[] args) {

		Ex6 ex = new Ex6(1, 2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		A a = new B();
		F f = new F();
		D d = new D();
		
		/*
		 * a = (A)d;
		 * a = d
		 * B b = (B)a;
		 * C c = f;
		 * d = (D)a;
		 * B b = d;
		 * */
		
	}




	
}

class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends B {}
class F extends C {}
class G extends C {}



