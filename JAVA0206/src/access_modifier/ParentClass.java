package access_modifier;

// 접근 제한자에 따른 접근 범위 차이 확인을 위한 슈퍼클래스 정의
public class ParentClass {
	public int publicVar;
	protected int protectedVar;
	int defaultVar;
	private int privateVar;
	
	public void useMember() {
		this.publicVar = 10;
		this.protectedVar = 20;
		this.defaultVar = 30;
		this.privateVar = 40;
	}
}
