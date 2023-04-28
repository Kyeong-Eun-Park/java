package test8_member;

import java.sql.Date;

// study_jsp3.test4_member 테이블 레코드 1개 정보를 저장하는 MemberDTO 클래스 정의
public class MemberDTO {
	// 1. test4_member 테이블의 각 컬럼에 대응하는 멤버변수 선언
	private int idx;
	private String name;
	private String id;
	private String passwd;
	private String jumin;
	private String email;
	private String job;
	private String gender;
	private String hobby;
	private String motivation;
	private Date hire_date;

	// 2. 생성자 정의(생략 가능) - 생략 시 기본 생성자가 자동으로 생성됨
//	public MemberDTO() {} // 기본 생성자

	// 3. 각 멤버변수에 접근하기 위한 Getter/Setter 메서드 정의
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getMotivation() {
		return motivation;
	}
	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [idx=" + idx + ", name=" + name + ", id=" + id + ", passwd=" + passwd + ", jumin=" + jumin
				+ ", email=" + email + ", job=" + job + ", gender=" + gender + ", hobby=" + hobby + ", motivation="
				+ motivation + ", hire_date=" + hire_date + "]";
	}

	
}















