package kr.co.soldesk.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserBean {

	@NotBlank(message = "ID는 필수 입력 사항입니다.")
	@Size(min = 4, max = 20, message = "ID는 4~20자여야 합니다.")
	private String user_id;

	@NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
	@Size(min = 6, max = 20, message = "비밀번호는 6~20자여야 합니다.")
	private String user_pass;

	@NotBlank(message = "이름은 필수 입력 사항입니다.")
	private String user_name;

	@Min(value = 10, message = "나이는 10세 이상이어야 합니다.")
	@Max(value = 100, message = "나이는 100세 이하이어야 합니다.")
	private int user_age;

	private String user_gender;

	private String user_job;

	private String user_address;

	private boolean login;

	public UserBean() {
		user_name = "익명";
		user_age = 10;
		login = false;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_job() {
		return user_job;
	}

	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

}
