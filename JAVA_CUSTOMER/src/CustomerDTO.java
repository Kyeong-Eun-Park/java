

public class CustomerDTO {
	// 멤버변수 5개 선언
	private String idx;
	private String name;
	private String age;
	private String eMail;
	private String jumin;
	
	public CustomerDTO() {}
	public CustomerDTO(String idx, String name, String age, String eMail, String jumin) {
		this.idx = idx;
		this.name = name;
		this.age = age;
		this.eMail = eMail;
		this.jumin = jumin;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [idx=" + idx + ", name=" + name + ", age=" + age + ", eMail=" + eMail + ", jumin=" + jumin
				+ "]";
	}
}
