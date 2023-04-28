package ref_casting;
//class Phone {
//	public void call() {}
//	public void sms() {}
//}
//
//class SmartPhone extends Phone {
//	public void kakao() {}
//}

public class Test2 {

	public static void main(String[] args) {
//		Phone p = new SmartPhone();
		
		F f = new F();
		A a = f;
		C c = (C)a;
		F f2 = (F)c;
		H h = (H)f2;
	}
}

class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends B {}
class F extends C {}
class G extends C {}
class H extends F {}



