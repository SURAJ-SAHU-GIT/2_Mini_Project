package in.suraj.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SignUpForm {

	@NotBlank(message = "Name should not be empty")
	private String name;

	@NotBlank(message = "Email should not be empty")
	private String email;

	@NotNull(message = "phone number is mandatory")
	// @Size(min = 10,max = 13,message = "Invalid Phone Number" )
	private Long phno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	
}
