package rabbitmq.domain;

import java.util.Date;
import java.util.List;

import com.niit.userTaskService.domain.Tasks;

public class UserDto {
	
	private String email;
	private String username;
	private String password;
	private List<Tasks> tasklist;

	public UserDto() {
	}

	public UserDto(String email, String username, String password, List<Tasks> tasklist) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.tasklist = tasklist;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public List<Tasks> getTasklist() {
		return tasklist;
	}

	public void setTasklist(List<Tasks> tasklist) {
		this.tasklist = tasklist;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", tasklist=" + tasklist +
				'}';
	}
}
