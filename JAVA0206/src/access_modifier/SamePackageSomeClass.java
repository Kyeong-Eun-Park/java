package access_modifier;

public class SamePackageSomeClass {
	
	// 패키지가 동일한 다른 클래스에서 접근 범위 (서로 다른 java 파일 내)
	public void useMember() {
		ParentClass p = new ParentClass();
		p.publicVar = 10;	// (O) - 누구나 접근 가능
		p.protectedVar = 20;// (O) - 같은 패키지이므로 접근 가능
		p.defaultVar = 30;	// (O) - 같은 패키지이므로 접근 가능
//		p.privateVar = 40;	// (X) - 다른 클래에서 접근 불가
	}
}
