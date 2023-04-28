package test9_member;

// 포워딩 정보(포워딩 방식과 포워딩 주소)를 관리하는 ActionForward 클래스 정의 = DTO 역할과 유사
public class ActionForward {
	private String path; // 포워딩 주소(URL)
	private boolean isRedirect; // 포워딩 방식(true : Redirect 방식, false : Dispatch 방식)
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
