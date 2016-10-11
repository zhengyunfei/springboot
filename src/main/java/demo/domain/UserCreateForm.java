package demo.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 创建用户字段POJO定义
 * 
 * @author jiekechoo
 *
 */
public class UserCreateForm {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	@NotEmpty
	private String passwordRepeat;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	@Override
	public String toString() {
		return "UserCreateForm [username=" + username + ", password="
				+ password + ", passwordRepeat=" + passwordRepeat + "]";
	}

}
