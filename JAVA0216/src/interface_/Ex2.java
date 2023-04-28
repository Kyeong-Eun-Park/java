package interface_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 인터페이스 필요성 (장점)
		 * 4. 모듈간 독립적 프로그래밍으로 인한 개발 기간 단축
		 * 	- 각 모듈간에 연계된 부분을 공통 인터페이스 내의 추상메서드로 구현하고
		 *    각 모듈에서는 해당 인터페이스를 상속받아 구현함으로써
		 *    공통된 작업 형태를 지닌 채 각각 서로의 작업만 작성하고
		 *    상대방의 작업 진행 여부와 관계없이 임의의 데이터로 테스트가 가능하다!
		 *  - 따라서, 서로간의 작업 진행관 관계없이 각자의 작업이 진행되고
		 *    공통 모율을 통해 테스트가 수행되기 때문에 개발 기간이 단축된다!  
		 * */
		// 개발자 코드 동작 확인
		// => 디자이너측에서 생성하여 전달할 아이디, 패스워드를 임의로 입력하여 확인
		DeveloperLogin dl = new DeveloperLogin();
		String result = dl.login("adminn", "1234");
		System.out.println("로그인 결과: " + result);
		System.out.println("--------------------------");
		
		// 디자이너 코드 동작 확인
		DesinerLogin dl2 = new DesinerLogin();
		dl2.inputLogin();
	}
}

// 개발자와 디자이너가 수행해야하는 작업들의 공통 부분을 추상메서드로 정의하여
// 기본적인 틀을 제시하면 개발자와 디자이너는 각각 별도로 독립된 작업 수행이 가능하다!
interface LoginInterface {
	// 디자이너: 입력받은 id, password를 문자열로 전달
	// 개발자: id, password를 전달받아 로그인 처리 후 결과를 문자열로 리턴
	public String login(String id, String password);
}

// 개발자가 수행해야하는 로그인 처리 작업
// => 공통 인터페이스를 상속받아 추상메서드를 구현하여 로그인 작업 수행 가능
//    이 때, 디자이너쪽에서 넘어올 데이터는 임의의 데이터로 대체 가능 (테스트)
//    상호간에 사용할 파라미터를 미리 매개변수로 정했기 때문
class DeveloperLogin implements LoginInterface {

	@Override
	public String login(String id, String password) {
		System.out.println("아이디: " + id);
		System.out.println("패스워드: " + password);
		
		String result = "";
		if(id.equals("admin") && password.equals("1234")) {
			result = "로그인 성공!";
		} else {
			result = "로그인 실패!";
		}
		
		return result;
	}
	
}

// 디자이너가 수행해야하는 로그인 정보 전달 및 전달 후 결과 처리 작업
// 개발자측에 전달할 데이터(아이디, 패스워드)를 생성하여
// 공통 추상메서드를 구현하여 파라미터로 전달햇을 때 데이터가 잘 전달되었는지 확인하고
// 리턴되는 결과값을 임의로 설정하여 리턴 후 리턴된 데이터를 전달받아 확인
class DesinerLogin implements LoginInterface {

	@Override
	public String login(String id, String password) {
		// 실제로는 개발자가 구현할 메서드 이지만
		// 개발자와 별개로 독립적인 작업을 위해 공통 메서드를 임시로 구현하여
		// 개발자 입장에서 처리할 코드는 생략하고
		// 디자이너가 전달하는 데이터가 잘 전달되었는지만 확인
		System.out.println("아이디: " + id);
		System.out.println("패스워드: " + password);
		
		return "로그인 성공";
	}
	
	// 디자이너가 외부로부터 아이디, 패스워드를 생성하여 개발자에게 넘겨줄 메서드 정의
	public void inputLogin() {
		// 임의의 로그인 정보를 입력받았다고 가정
		String id = "admin";
		String password = "1234";
		
		// 공통 메서드인 login() 메서드를 호출하여 파라미터가 잘 전달되었는지 확인하고
		// login() 메서드에 임의의 리턴값을 설정하여 리턴된 데이터가 잘 출력되는지 확인
		String result = login(id, password);
		System.out.println("결과: " + result);
	}
	
}
















